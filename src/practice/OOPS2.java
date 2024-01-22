package practice;

class Student2{
    int age;
    String name;

    public void printInfo(){
        System.out.println(this.age);
        System.out.println(this.name);
    }
    public Student2(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class House{
    int noOfRooms;
    String Name1;
    String Name2;
    int noOfBoys;
    int noOfGirls;

    public House(int noOfRooms, String name1, String name2, int noOfBoys, int noOfGirls) {
        this.noOfRooms = noOfRooms;
        Name1 = name1;
        Name2 = name2;
        this.noOfBoys = noOfBoys;
        this.noOfGirls = noOfGirls;
    }
}
public class OOPS2 {
    public static void main(String[] args) {
        Student2 s1 = new Student2(25 , "dasu");
        s1.printInfo();
        System.out.println(s1.name);
        System.out.println(s1.age);

//        House houseDetails = new House( 3 , "dasu" , " manju" , 4 , 1);
//        System.out.println(houseDetails.noOfBoys);
    }
}
