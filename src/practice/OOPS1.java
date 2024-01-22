package practice;

//class pen{
//// properties
//    String color;
//    String type;
//// methods or functions
//    public static void write(){
//        System.out.println("writing with the pen");
//    }
//    public void printColor(){
//        System.out.println(this.color);
//    }
//}
class Student{
    String name;
    int rollno;
    public void printInfo(){
        System.out.println(this.name);
    }

}

public class OOPS1 {
    public static void main(String[] args) {
        //objects

    Student student = new Student();
    student.name = "dasussssssss";
    student.printInfo();
//    pen pen1 = new pen();
//    pen1.color = "RED";
//    pen1.type = "BallPoint Pen";
////    pen1.write();
//
//    pen pen2 = new pen();
//    pen2.color = "Yellow";
//    pen2.type = " gel pen";
//    pen1.printColor();
//    pen2.printColor();
//    pen2.write();

//    System.out.println(pen1.color);
    }
}

//public class Student {
//    private int id;
//
//    public Student(int id) {
//        this.id = id;
//    }
//
//    public static void main(String[] args) {
//        // This is a static method
//        // Attempting to access a non-static member 'id' directly will result in an error
//
//        // Incorrect way to access 'id' from a static context
//        System.out.println(id); // Causes error: non-static variable 'id' cannot be referenced from a static context
//
//        // Correct way to access 'id' is by creating an instance of the class
//        Student student = new Student(123);
//        System.out.println(student.id); // This will work
//    }
//}

