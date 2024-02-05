package Projects;

public class InitializationThroughMethod {
    static class Employee{
        private int id;
        private String name;
        private float salary;
        void insertDetails(String name, int id){
            this.name=name;
            this.id = id;
        }
        void insertDetails(String name, int id,float salary){
            this.name=name;
            this.id = id;
            this.salary=salary;
        }
        void display(){
            System.out.println( id + " " + name + " " + salary);

        }
    }
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Employee employee4 = new Employee();

        employee1.insertDetails("dasu" , 1,500000);
        employee2.insertDetails("sai" , 2);
        employee3.insertDetails("ravi" , 3);
        employee4.insertDetails("teja" , 4,100000);
        employee4.display();
        employee1.display();

    }
}
