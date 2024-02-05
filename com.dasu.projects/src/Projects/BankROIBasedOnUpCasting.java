package Projects;

public class BankROIBasedOnUpCasting {
    public static void main(String[] args) {
        Bank1 objBank = null;
        objBank = new SBIBank();
        System.out.println(objBank.getRateOfInterest());
    }
}

 class Bank1{
    int getRateOfInterest(){
        return 0;
    }

}
 class SBIBank extends Bank1{

    int getRateOfInterest(){
//        System.out.println("SBI Bank");
        return 8;
    }
}
class ICICIBank extends Bank1{
    int getRateOfInterest(){
        System.out.println("ICICI BAnk");
        return 7;
    }
}
class AXISBank extends Bank1{
    int getRateOfInterest(){
        System.out.println("AXIS BAnk");
        return 6;
    }
}