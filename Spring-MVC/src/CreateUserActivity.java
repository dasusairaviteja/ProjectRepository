public class CreateUserActivity {

    @Service
    public class UserActivityServiceImpl implements UserActivityService {

        private static final Logger LOG = LoggerFactory.getLogger(UserActivityServiceImpl.class);

        @Autowired
        private ApplicationProperties applicationProperties;

        @Autowired
        private UserActivityDao userActivityDao;

        @Autowired
        private TenantService tenantService;

        @Autowired
        private UserService userService;

        @Autowired
        private ExternalApplicationService externalApplicationService;

        @Autowired
        private PermissionService permissionService;

        @Autowired
        private RoleService roleService;

        @Autowired
        private UserDao userDao;

        @Override
        public void createUserActivity(HttpServletRequest request, int statusCode,
                                       Object responseBody) throws UnsupportedEncodingException {
            LOG.info("Start of createUserActivity service method.");
            HttpMethod httpMethod = HttpMethod.resolve(request.getMethod());
            UserActivityRequest userActivity = new UserActivityRequest();
            userActivity.setIpAddress(getIpAddress(request));
            userActivity.setVerb(Objects.requireNonNull(httpMethod).name());
            String url = getUrl(request.getRequestURI());
            // Exclude UserActivity log in case of url: /api/error
            if(UserActivityConstant.EXCLUDE_URL.equalsIgnoreCase(url)) {
                return;
            }
            userActivity.setUrl(url);

            if (responseBody instanceof ApiError) {
                String errorMessage = null;
                List<String> errors = ((ApiError) responseBody).getAllErrors();
                if (CollectionUtils.isNotEmpty(errors)) {
                    errorMessage = String.join(System.lineSeparator(), errors);
                }
                if (errorMessage != null) {
                    userActivity.setErrorMessage(errorMessage.replaceAll("'", "''"));
                }
            }

            getObjectDetails(userActivity, url, responseBody, httpMethod);
            UserActivityTokenDetails tokenDetails = getTokenDetails(request.getHeader("authorization"));
            if (tokenDetails != null) {
                userActivity.setClientId(tokenDetails.getClientId());
                userActivity.setUserId(tokenDetails.getUserId());
                userActivity.setTenantId(tokenDetails.getTenantId());
            }

            userActivity.setHttpResponseCode(statusCode);
            userActivity.setDataStreamResponseCode(statusCode);
            if (statusCode >= 200 && statusCode <= 204) {
                userActivity.setStatus(true);
            }
            Object requestBodyListObject = RequestContextHolder.currentRequestAttributes().getAttribute(
                    ApplicationConstant.REQUEST_BODY_LIST, RequestAttributes.SCOPE_REQUEST);
            String requestBody = null;
            try {
                requestBody = getRequestBody(request);
            } catch (IOException e) {
                LOG.error("Error: {}", e.getMessage());
                e.printStackTrace();
            }
            userActivity.setRequestBody(StringUtils.isNotEmpty(requestBody) ? requestBody : null);
            List<UserActivityRequest> userActivities = new ArrayList<>();
            if ((HttpMethod.POST == httpMethod || HttpMethod.DELETE == httpMethod) && requestBodyListObject instanceof List
                    && !StringUtils.isEmpty(userActivity.getObjectType2()) && StringUtils.isEmpty(userActivity.getObjectId2())) {
                List requestBodyList = (List) requestBodyListObject;
                for (Object obj : requestBodyList) {
                    UserActivityRequest userActivityObject1 = userActivity.clone();
                    userActivityObject1.setObjectId2(obj.toString());
                    setObjectOtherDetails(userActivityObject1, UserActivityConstant.SECOND_OBJECT, userActivity.getObjectType2(), obj.toString());
                    userActivities.add(userActivityObject1);
                }
            } else {
                userActivities.add(userActivity);
            }
            saveUserActivities(userActivities);
            LOG.info("End of createUserActivity service method.");
        }

        private String getRequestBody(HttpServletRequest request) throws IOException {
            LOG.info("Start of getRequestBody service method.");
            CachedBodyHttpServletRequest cachedBodyHttpServletRequest =
                    new CachedBodyHttpServletRequest(request);
            String line;
            StringBuilder jsonStringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(cachedBodyHttpServletRequest.getInputStream()));
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            LOG.info("End of getRequestBody service method.");
            return jsonStringBuilder.toString();
        }

        /**
         * Returns domain level identifier from request/response objects
         */
        private static String getDomainLevelIdentifier(Object responseBody) {
            LOG.info("Start of getDomainLevelIdentifier service method.");
            String domainLevelId = null;
            Object domainLevelIdentifier = RequestContextHolder.currentRequestAttributes()
                    .getAttribute(ApplicationConstant.DOMAIN_LEVEL_IDENTIFIER, RequestAttributes.SCOPE_REQUEST);
            if (domainLevelIdentifier != null) {
                domainLevelId = domainLevelIdentifier.toString();
            } else if (responseBody instanceof DomainLevelIdentifier) {
                domainLevelId = ((DomainLevelIdentifier) responseBody).getDomainLevelId();
            }
            LOG.info("End of getDomainLevelIdentifier service method.");
            return domainLevelId;
        }

        private String getUrl(String uri) throws UnsupportedEncodingException {
            try {
                return StringUtils.isNotEmpty(uri) ? URLDecoder.decode(uri, UserActivityConstant.UTF_8) : null;
            } catch (UnsupportedEncodingException e) {
                LOG.error("Url decode failed", e);
                throw e;
            }
        }

        private UserActivityTokenDetails getTokenDetails(String token) {
            if (StringUtils.isNotBlank(token)) {
                TokenModel tokenModel = Utils.getTokenModel(token);
                List<String> tenants = tokenModel.getTenants();
                Long tenantId = null;
                if (CollectionUtils.isNotEmpty(tenants)) {
                    tenantId = tenantService.getTenantIdByShortName(tenants.get(0));
                }
                return new UserActivityTokenDetails(tokenModel.getApplicationId(), tokenModel.getUserId(), tenantId);
            }
            return null;
        }

        @Override
        public void saveUserActivities(List<UserActivityRequest> userActivityRequests) {
            try {
                userActivityDao.createUserActivity(userActivityRequests);
            } catch (DataAccessException ex) {
                LOG.error("Failed inserting user activity log", ex);
                throw ex;
            }
        }

        @Override
        public Page<UserActivityResponse> listUserActivities(UserActivitySearchParams searchParams, Pageable pageable,
                                                             TokenModel tokenModel, boolean isTestData) {
            LOG.info("Start of listUserActivities service method.");
            if (EnvironmentEnum.SANDBOX == EnvironmentEnum.fromString(applicationProperties.getEnvironment())) {
                String tenantShortName = searchParams.getTenantShortName();
                if (tenantShortName == null) {
                    searchParams.setTenantShortName(tokenModel.getTenants().get(0));
                } else if (!tenantShortName.equalsIgnoreCase(tokenModel.getTenants().get(0))) {
                    LOG.error("Error: Permission Denied.");
                    throw new InvalidAccessException(MessageConstant.PERMISSION_DENIED);
                }
                if (!tokenModel.getRoles().contains(RoleEnum.DEVELOPER_ADMIN.getValue())) {
                    String userUpn = searchParams.getUserUpn();
                    if (userUpn == null) {
                        searchParams.setUserUpn(tokenModel.getUpn());
                    } else if (!userUpn.equalsIgnoreCase(tokenModel.getUpn())) {
                        LOG.error("Error: Permission Denied.");
                        throw new InvalidAccessException(MessageConstant.PERMISSION_DENIED);
                    }
                }
            } else {
                if (!tokenModel.getRoles().contains(RoleEnum.SYSTEM_ADMIN.getValue())) {
                    String tenantShortName = searchParams.getTenantShortName();
                    if (tenantShortName == null) {
                        searchParams.setTenantShortName(tokenModel.getTenants().get(0));
                    } else if (!tenantShortName.equalsIgnoreCase(tokenModel.getTenants().get(0))) {
                        LOG.error("Error: Permission Denied.");
                        // throw new InvalidAccessException(MessageConstant.PERMISSION_DENIED);
                    }
                }
                String userUpn = searchParams.getUserUpn();
                if (userUpn != null) {
                    //  UserResponse user = userService.getUserByUpn(userUpn);
                    UserResponse user = userDao.getUserByUpn(userUpn);
                    if (null != user && !tokenModel.getTenants().get(0).equalsIgnoreCase(user.getTenantShortName())) {
                        LOG.error("Error: Permission Denied.");
                        //  throw new InvalidAccessException(MessageConstant.PERMISSION_DENIED);
                    }
                }
            }

            LOG.info("End of listUserActivities service method.");
            return userActivityDao.listUserActivities(searchParams, pageable, isTestData);
        }

        private static String getIpAddress(HttpServletRequest request) {
            String ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
            if ((ipAddress != null) && (ipAddress.length()) > 15) {
                int index = ipAddress.indexOf(",");
                if (index > 0) {
                    ipAddress = ipAddress.substring(0, index);
                }
            }
            if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
                ipAddress = "127.0.0.1";
            }
            return ipAddress;
        }

        private void getObjectDetails(UserActivityRequest event, String requestUrl, Object responseBody,
                                      HttpMethod httpMethod) {
            if (StringUtils.isNotEmpty(requestUrl)) {
                if (requestUrl.trim().contains("/api/v1/")) {
                    requestUrl = requestUrl.substring(8);
                    setObjectDetails(event, requestUrl, responseBody, httpMethod);
                } else if (requestUrl.trim().contains("/api/reports/members/v1/")) {
                    requestUrl = requestUrl.substring(24);
                    setObjectDetails(event, requestUrl, responseBody, httpMethod);
                }
            }
        }

        private void setObjectDetails(UserActivityRequest event, String requestUrl, Object responseBody,
                                      HttpMethod httpMethod) {
            LOG.info("Start of setObjectDetails service method.");
            String objectType1 = null, objectId1 = null, objectType2 = null, objectId2 = null;
            int index = requestUrl.indexOf("/");
            if (index > 0) {
                objectType1 = requestUrl.substring(0, index);
                event.setObjectType1(objectType1);
                requestUrl = requestUrl.substring(index + 1);
                index = requestUrl.indexOf("/");
                if (index > 0) {
                    objectId1 = requestUrl.substring(0, index);
                    event.setObjectId1(objectId1);
                    setObjectOtherDetails(event, UserActivityConstant.FIRST_OBJECT, objectType1, objectId1);
                    requestUrl = requestUrl.substring(index + 1);
                    index = requestUrl.indexOf("/");
                    if (index > 0) {
                        objectType2 = requestUrl.substring(0, index);
                        event.setObjectType2(objectType2);
                        objectId2 = requestUrl.substring(index + 1);
                        event.setObjectId2(objectId2);
                        setObjectOtherDetails(event, UserActivityConstant.SECOND_OBJECT, objectType2, objectId2);
                    } else {
                        objectType2 = requestUrl;
                        event.setObjectType2(objectType2);
                    }
                } else {
                    objectId1 = requestUrl;
                    event.setObjectId1(objectId1);
                    if (objectType1.equalsIgnoreCase(ApplicationConstant.EXTERNALAPPLICATIONS_OBJECT)
                            || objectType1.equalsIgnoreCase(ApplicationConstant.PERMISSIONS_OBJECT)
                            || objectType1.equalsIgnoreCase(ApplicationConstant.ROLES_OBJECT)) {
                        if (HttpMethod.DELETE == httpMethod) {
                            if (objectType1.equalsIgnoreCase(ApplicationConstant.EXTERNALAPPLICATIONS_OBJECT)) {
                                ExternalApplicationResponse externalApplicationResponse =
                                        (ExternalApplicationResponse) RequestContextHolder.currentRequestAttributes()
                                                .getAttribute(ApplicationConstant.RESPONSE_BODY, RequestAttributes.SCOPE_REQUEST);
                                if (ObjectUtils.isNotEmpty(externalApplicationResponse)) {
                                    event.setObjectName1(externalApplicationResponse.getName());
                                    event.setObjectTenantShortName1(externalApplicationResponse.getTenantShortName());
                                }
                            } else if (objectType1.equalsIgnoreCase(ApplicationConstant.ROLES_OBJECT)) {
                                RoleResponse roleResponse = (RoleResponse) RequestContextHolder.currentRequestAttributes()
                                        .getAttribute(ApplicationConstant.RESPONSE_BODY, RequestAttributes.SCOPE_REQUEST);
                                if (ObjectUtils.isNotEmpty(roleResponse)) {
                                    event.setObjectName1(roleResponse.getName());
                                    event.setObjectTenantShortName1(roleResponse.getTenantShortName());
                                    event.setObjectApplicationName1(roleResponse.getApplicationName());
                                }
                            }
                        } else {
                            setObjectOtherDetails(event, UserActivityConstant.FIRST_OBJECT, objectType1, objectId1);
                        }
                    }
                }
            } else {
                objectType1 = requestUrl;
                event.setObjectType1(objectType1);
                // for create actions set object id1 as per the domain level identifier
                if (HttpMethod.POST == httpMethod) {
                    event.setObjectId1(getDomainLevelIdentifier(responseBody));
                    if (objectType1.equalsIgnoreCase(ApplicationConstant.EXTERNALAPPLICATIONS_OBJECT)
                            || objectType1.equalsIgnoreCase(ApplicationConstant.PERMISSIONS_OBJECT)
                            || objectType1.equalsIgnoreCase(ApplicationConstant.ROLES_OBJECT)) {
                        setObjectOtherDetails(event, UserActivityConstant.FIRST_OBJECT, objectType1, event.getObjectId1());
                    }
                }

            }
            if (StringUtils.isNotEmpty(objectType2)) {
                if (HttpMethod.POST == httpMethod)
                    event.setActivityType(ActivityTypeEnum.GRANT);
                else if (HttpMethod.DELETE == httpMethod)
                    event.setActivityType(ActivityTypeEnum.REVOKE);
            } else {
                if (HttpMethod.POST == httpMethod)
                    event.setActivityType(ActivityTypeEnum.CREATE);
                else if (HttpMethod.PUT == httpMethod)
                    event.setActivityType(ActivityTypeEnum.UPDATE);
                else if (HttpMethod.DELETE == httpMethod)
                    event.setActivityType(ActivityTypeEnum.DELETE);
            }

        }

        private void setObjectOtherDetails(UserActivityRequest event, String objectCategory, String objectType, String objectId) {
            LOG.info("Start of setObjectOtherDetails service method.");
            if (StringUtils.isNotEmpty(objectType) && StringUtils.isNotEmpty(objectId)) {
                //externalApplications
                if (objectType.equalsIgnoreCase(ApplicationConstant.EXTERNALAPPLICATIONS_OBJECT)) {
                    ExternalApplicationResponse externalApplicationResponse = externalApplicationService.getExternalApplicationById(objectId);
                    if (ObjectUtils.isNotEmpty(externalApplicationResponse)) {
                        if (objectCategory.equalsIgnoreCase(UserActivityConstant.FIRST_OBJECT)) {
                            event.setObjectName1(externalApplicationResponse.getName());
                            event.setObjectTenantShortName1(externalApplicationResponse.getTenantShortName());
                        } else {
                            event.setObjectName2(externalApplicationResponse.getName());
                            event.setObjectTenantShortName2(externalApplicationResponse.getTenantShortName());
                        }
                    }
                }
                //permissions
                if (objectType.equalsIgnoreCase(ApplicationConstant.PERMISSIONS_OBJECT)) {
                    PermissionResponse permissionResponse = permissionService.getPermissionById(Long.parseLong(objectId));
                    if (ObjectUtils.isNotEmpty(permissionResponse)) {
                        if (objectCategory.equalsIgnoreCase(UserActivityConstant.FIRST_OBJECT)) {
                            event.setObjectName1(permissionResponse.getName());
                            event.setObjectApplicationName1(permissionResponse.getApplicationName());
                        } else {
                            event.setObjectName2(permissionResponse.getName());
                            event.setObjectApplicationName2(permissionResponse.getApplicationName());
                        }
                    }
                }
                //roles
                if (objectType.equalsIgnoreCase(ApplicationConstant.ROLES_OBJECT)) {
                    RoleResponse roleResponse = roleService.getRoleById(Long.parseLong(objectId));
                    if (ObjectUtils.isNotEmpty(roleResponse)) {
                        if (objectCategory.equalsIgnoreCase(UserActivityConstant.FIRST_OBJECT)) {
                            event.setObjectName1(roleResponse.getName());
                            event.setObjectTenantShortName1(roleResponse.getTenantShortName());
                            event.setObjectApplicationName1(roleResponse.getApplicationName());
                        } else {
                            event.setObjectName2(roleResponse.getName());
                            event.setObjectTenantShortName2(roleResponse.getTenantShortName());
                            event.setObjectApplicationName2(roleResponse.getApplicationName());
                        }
                    }
                }
            }
        }

        @Getter
        @AllArgsConstructor
        private static class UserActivityTokenDetails {
            private String clientId;
            private String userId;
            private Long tenantId;
        }
    }


}
