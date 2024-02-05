package Projects;

public class CountNumberOfEmployeesEntered {
     static int count = 0;

    CountNumberOfEmployeesEntered(){
        for (int i = 0; i < 10; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        CountNumberOfEmployeesEntered c1 = new CountNumberOfEmployeesEntered();
//        CountNumberOfEmployeesEntered c2 = new CountNumberOfEmployeesEntered();
//        CountNumberOfEmployeesEntered c3 = new CountNumberOfEmployeesEntered();
        System.out.println("Total count is  " + count);
    }
}
