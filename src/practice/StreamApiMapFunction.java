package practice;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiMapFunction {
    public static void main(String[] args) {
        List<String> mappingToUpperCase = Arrays.asList("d" ,"a" ,"s" ,"u");
        List<Integer> mappingNumberSquare = Arrays.asList(2,3,5,7);
        System.out.println(mappingToUpperCase.stream().map(String::toUpperCase).collect(Collectors.toList()));
        System.out.println(mappingNumberSquare.stream()
                .map(m -> m * 2)
                .collect(Collectors.toList()));





    }
    }

