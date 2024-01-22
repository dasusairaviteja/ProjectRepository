package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AL {
    public static void main(String[] args) {
              Scanner scanner = new Scanner(System.in);
              ArrayList<Integer> list = new ArrayList<>(10);
//            list.add(10);
//            list.add(20);
//            list.add(30);
//            list.add(40);
//            list.add(50);
//            list.add(60);
//            list.add(70);
//            list.add(80);
//
//            System.out.println(list);
//            System.out.println(list.indexOf(20));

        for (int items = 0; items < 5; items++) {
            list.add(scanner.nextInt());
            System.out.println(list.get(items));

        }
    }
}
