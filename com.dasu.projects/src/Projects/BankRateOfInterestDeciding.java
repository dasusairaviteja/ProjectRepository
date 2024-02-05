package Projects;

public class BankRateOfInterestDeciding {
    public static void main(String[] args) {
        SBI s = new SBI();
        ICICI icici = new ICICI();
        AXIS axis = new AXIS();
        System.out.println("The rate of interest at SBI is----->"+s.getSbiRateOfInterest());
    }
}
class Bank{
    static int rateOfInterest(){
        return 0;
    }
}
class SBI extends Bank{
     int getSbiRateOfInterest(){
        return 8;
    };
}
class ICICI extends Bank{
    static int getIciciRateOfInterest(){
        return 7;
    }
}
class AXIS extends Bank{
    static int getAxisRateOfInterest(){
        return 6;
    }
}


