package Projects;

public class EmployeeDetailsInhereited {
    public static void main(String[] args) {
        Employee e = new Employee("dasu", 1, 5000);
        e.display();
    }
}

class Person{
    int id;
    String name;
    Person(String name , int id){
        this.id=id;
        this.name=name;
    }
}
class Employee extends Person{
    float salary;
    Employee(String name, int id,float salary) {
        super(name, id);
        this.salary=salary;
    }
    void display(){
        System.out.println("Id Number is----> " + id + ", His Name is ---> " +
                name +" and " +" Dasu salary is---> "+ salary);

    }

}
