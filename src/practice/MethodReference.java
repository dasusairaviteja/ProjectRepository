package practice;

import java.awt.*;
import java.awt.print.Printable;
import java.util.function.BiFunction;
import java.util.function.Function;

//    @FunctionalInterface
//    interface printable{
//        void print(String msg);
//    }
//
//
//        public class MethodReference {
//
//        public static int addition ( int a, int b){
//            return a + b;
//        }
//        public static void main (String[]args){
//
//            //1.lambda implementation
//            Function<Integer, Double> functionInterface = (input) -> Math.sqrt(input);
//            System.out.println(functionInterface.apply(4));
//            //2.method reference
//            Function<Integer, Double> functionInterfaceImpl = Math::sqrt;
//            System.out.println(functionInterface.apply(16));
//
//            BiFunction<Integer, Integer, Integer> biFunctionalLambda = (a, b) -> MethodReference.addition(a, b);
//            System.out.println(biFunctionalLambda.apply(10, 20));
//
//            //methodreference
//            BiFunction<Integer, Integer, Integer> biFunctionalMethod = MethodReference::addition;
////            System.out.println(biFunctionalLambda.apply(10, 30));
////
//            //method referece for instance of object
//            MethodReference methodReference = new MethodReference();
//            Printable printable = (msg) -> MethodReference.display(msg);
//            printable.print("hello world");
//
//        }


//
//            private static int display(String msg) {
//                msg = msg.toUpperCase();
////                System.out.println(msg);
////            }
////
//
//        }