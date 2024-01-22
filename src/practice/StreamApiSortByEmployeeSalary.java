package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    private int idNumber;
    private String officeLocation;
    private int salary;
    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "idNumber=" + idNumber +
                ", officeLocation='" + officeLocation + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(int idNumber, String officeLocation, int salary, String name) {
        this.idNumber = idNumber;
        this.officeLocation = officeLocation;
        this.salary = salary;
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class StreamApiSortByEmployeeSalary {
    public static void main(String[] args) {
        List<Employee> employeeDetails = new ArrayList<Employee>();
        employeeDetails.add(new Employee(100102 , "california" , 7500 , "Raghu"));
        employeeDetails.add(new Employee(100100 , "Dallas" , 5000 , "Dasu"));

        employeeDetails.add(new Employee(100101 , "NewYork" , 6000 , "Sree"));

        employeeDetails.add(new Employee(100103 , "San Fransisco" , 8500 , "Abhinav"));
        employeeDetails.add(new Employee(100104 , "San Antonio" , 5500 , "Karthik"));


//        List<Employee> employeeDetailsFinal = employeeDetails.stream().sorted(( o1,  o2) -> (o1.getSalary() - o2.getSalary()))
//                .collect(Collectors.toList());
//        System.out.println(employeeDetailsFinal);
//        List<Employee> employeeDetailsFinal1 = employeeDetails.stream().sorted(Comparator.comparingLong(Employee::getIdNumber) )
//                .collect(Collectors.toList());
//        System.out.println(employeeDetailsFinal1);
//        List<Employee> employeeDetailsFinal2 = employeeDetails.stream().sorted(Comparator.comparingLong(Employee::getIdNumber).reversed() )
//                .collect(Collectors.toList());
//        System.out.println(employeeDetailsFinal2);

        System.out.print(employeeDetails.stream().sorted(Comparator.comparingInt(Employee::getIdNumber)).collect(Collectors.toList()));

        }

    }
