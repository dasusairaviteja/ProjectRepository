package practice;

public class PolymorphismImplementation {



    static void add(int a , int b){
        System.out.println(a+b);
    }

    static void add(int a , int b,int c){
        System.out.println(a+b+c);
    }
    public static void main(String[] args) {
        PolymorphismImplementation pi = new PolymorphismImplementation();
        pi.add(10,20);
        pi.add(10,10,30);

    }
}
