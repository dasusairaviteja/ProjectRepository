package practice;

import java.sql.SQLOutput;

interface Vehicle{
    int noOfcylinders();
    String getBrand();
    String speedingUp();
    String slowingDown();

    default String turningAlarmOn(){
        return " Alarm on";

    }
    default String turningAlarmOff(){
        return " Alarm off";
    }

}

class Car implements Vehicle{

    @Override
    public int noOfcylinders() {
        return 12;
    }

    @Override
    public String getBrand() {
        return "BMW";
    }

    @Override
    public String speedingUp() {
        return "BMW is speeding up to max 200 MPH";
    }

    @Override
    public String slowingDown() {
        return "BMW is slowing down to 10 MPH due to weather conditions";
    }
}

public class DefaultAndStaticMethodsImpl2 {
    public static void main(String[] args) {

        Vehicle vehcile = new Car();
        System.out.println(vehcile.getBrand());
        System.out.println(vehcile.noOfcylinders());
        System.out.println(vehcile.turningAlarmOff());
        System.out.println(vehcile.turningAlarmOn());

    }
}
