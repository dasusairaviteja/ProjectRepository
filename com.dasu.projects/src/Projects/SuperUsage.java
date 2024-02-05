package Projects;

import java.sql.SQLOutput;

public class SuperUsage {
    public static void main(String[] args) {
        Dogs d = new Dogs();
        System.out.println("Age of my dog is---> " + d.dogAge + " years");
        d.dogsColor();
        d.animals();
    }
}

class Animals{
    String color = "Yellow";

    void animals(){
        System.out.println("Animal is created");
        System.out.println("Hello Animals");
    }
}
class Dogs extends Animals{

    int dogAge = 5;
//    Dogs(){
//        super();
//    }
// or We can use like this without defining the super keyword
    Dogs(){

    }

    void dogsColor(){
        String color = "Red";
        System.out.println(color);
        System.out.println(super.color);
    }
}