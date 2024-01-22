//package practice;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class userDTO{
//    private int id;
//    private String name;
//    private String email;
//
//    public userDTO(int id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "user{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
//}
//class user{
//    private int id;
//    private String name;
//    private String password;
//    private String email;
//
//    public user(int id, String name, String password, String email) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "user{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
//public class StreamApiMapMethodUserUserDTO {
//    public static void main(String[] args) {
//        List<user> details = new ArrayList<>();
//        details.add(new user(100 , "dasu" , "abcd" , "dasu@gmail.com"));
//        details.add(new user(101 , "sai" , "efgh" , "sai@gmail.com"));
//        details.add(new user(102 , "ravi" , "ijkl" , "ravi@gmail.com"));
//        List<userDTO> userDTOS = new ArrayList<>();
//        for(userDTO user : userDTOS){
//           userDTO.add(new userDTO(user.getId() ,user.getEmail() , user.getName()));
//        }
//
//        List<userDTO> printDetails = details.stream().map((user -> new userDTO(user.getId() , user.getName() , user.getEmail()))).forEach((userDTO -> {
//            System.out.println(userDTO);
//        }));
//        System.out.println(printDetails);
//
//    }
//}
//
