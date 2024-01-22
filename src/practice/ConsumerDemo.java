package practice;

import java.util.function.Consumer;

//class consumberImpl implements Consumer<String>{


//    @Override
//    public void accept(String input) {
//        System.out.println(input);
//    }


//}

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = (input) -> System.out.println(input);
        consumer.accept("dasu");
    }
}