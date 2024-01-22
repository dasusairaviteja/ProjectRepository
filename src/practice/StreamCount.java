package practice;

import java.util.stream.Stream;

public class StreamCount {
    public static void main(String[] args) {
        Stream<Integer> streamCount = Stream.of(1,5,9,7,8,5,2);
        System.out.println(streamCount.count());



    }
}
