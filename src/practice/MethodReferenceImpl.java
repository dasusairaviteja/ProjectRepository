package practice;

import java.util.Arrays;

public class MethodReferenceImpl {
    public static void main(String[] args) {
        String[] array = {"d" , "a" , "s" ,"u"};
        Arrays.sort(array ,(s1 , s2) -> s1.compareToIgnoreCase(s2) );
        System.out.println(Arrays.toString(array));
    }
}

