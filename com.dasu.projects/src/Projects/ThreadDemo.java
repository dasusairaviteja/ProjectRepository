package Projects;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> System.out.println("Run method"));
        thread.start();
    }
}
