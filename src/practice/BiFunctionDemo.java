package practice;

import java.util.function.BiFunction;

    public class BiFunctionDemo{
// implements BiFunction<Integer , Integer  ,Integer> {
//
//    @Override
//    public Integer apply(Integer integer, Integer integer2) {
//        return (integer + integer2);
//    }

    public static void main(String[] args) {
//        BiFunction<Integer , Integer,Integer> biFunction = new BiFunctionDemo();
//        System.out.println(biFunction.apply(10 , 20));

        // or you can sue this mabda
        BiFunction<Integer ,Integer,Integer > biFunction = (t, u) -> (t+u);
        System.out.println(biFunction.apply(10,20));

    }
}

