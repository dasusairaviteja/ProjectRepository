package practice;

public class ThreadMain {
    public static void main(String[] args) {
        System.out.println("start of thread");
        Thread Thread1 = new Thread1();
        Thread1.start();
        System.out.println("end of thread");
    }
}
