package practice;

public class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside thread1" + i);
        }
    }
}
