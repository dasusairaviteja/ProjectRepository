package Projects;

public class BankingSystemAccountManagement {
    static class Account {

        private int acc_no;
        private String name;
        private float amount;

        void insert(int ac_no, String nam, float amt) {
            this.acc_no = ac_no;
            this.amount = amt;
            this.name = nam;
        }

        void deposit(float amt) {
            amount = amount + amt;
            System.out.println(amt + " Dollars Deposited");
        }

        void withDraw(int amt) {
            if (amount < amt) {
                System.out.println("The amount available is insufficient in your account");
            } else {
                amount = amount - amt;
                System.out.println(amount + " withdrawn");
            }
        }

        void checkBalance() {
            System.out.println("Balance is: " + amount);
        }

        void display() {
            System.out.println(acc_no + " " + name + " " + amount);
        }
    }
}
 class AccountInsertion{
    public static void main(String[] args) {
        BankingSystemAccountManagement.Account a1=new BankingSystemAccountManagement.Account();
        a1.insert(832345,"Ankit",1000);
        a1.display();
        a1.checkBalance();
        a1.deposit(40000);
        a1.checkBalance();
        a1.withDraw(15000);
        a1.checkBalance();
    }
}


