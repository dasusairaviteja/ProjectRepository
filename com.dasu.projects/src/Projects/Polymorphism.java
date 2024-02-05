package Projects;

public class Polymorphism {
        static int addition(int a , int b){

            return a+b;
        }

        static int addition(int a , int b , int c){
            return a + b + c;
        }
        public static void main(String[] args) {

            Polymorphism polyM = new Polymorphism();
            System.out.println(addition(1,2,10));
            System.out.println(addition(1,10));

        }
    }

