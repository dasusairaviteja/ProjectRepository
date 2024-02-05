package Projects;

public class AccountsEmployeeGateNumber {

        int id;
        String name ;
        int accountDeptEntryGateNumber = 3;
        //creating a parameterized constructor
        AccountsEmployeeGateNumber(int id, String name){
            this.id = id;
            this.name = name;
        }

        AccountsEmployeeGateNumber(AccountsEmployeeGateNumber AEGN){
            this.id = AEGN.id;
            this.name=AEGN.name;
        }
        //method to display the values
        void display(){
            System.out.println("Employee holds id number===> "+ id +" with name on id as ===> "+ name +" and EntryGateNumber is ===> " +accountDeptEntryGateNumber);
        }
        public static void main(String[] args) {
            AccountsEmployeeGateNumber s1 = new AccountsEmployeeGateNumber(245987 , "Dasu");
            AccountsEmployeeGateNumber s2 = new AccountsEmployeeGateNumber(245988 ,"Padmaja");
            s1.display();
            s2.display();
        }
}


