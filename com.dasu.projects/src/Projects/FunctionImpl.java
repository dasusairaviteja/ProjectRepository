package Projects;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionImpl {
    public static void main(String[] args) {
        Function<String , Integer > function = (String s)-> s.length();
        Function<String,Integer> function1 = String :: length;
        System.out.println(function.apply("DASU"));
        System.out.println(function1.apply("DASUSAIRAVITEJA"));

        //consumer

        Consumer<String> consumer = (String s) -> System.out.println(s);//String is optional
        Consumer<Integer> consumer2 = (Integer i) -> System.out.println(i);
        Consumer<String> consumer1 = System.out::println;
        consumer.accept("DASU");
        consumer2.accept(100);
        consumer1.accept("DASUSAIRAVITEJA");

        //Supplier
        Supplier<String> supplier = ()-> "DASU---SRT";
        Supplier<LocalDateTime> supplier1 = () -> LocalDateTime.now();
        Supplier<LocalDateTime> supplier2 = LocalDateTime::now;
        String result = supplier.get();
        System.out.println();
        System.out.println( supplier1.get());
        System.out.println(result);

        Thread thread1 = new Thread(()-> System.out.println("Runnable"));
        thread1.start();
    }
}
