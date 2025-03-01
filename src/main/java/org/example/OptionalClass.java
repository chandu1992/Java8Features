package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalClass {
    public static void main(String[] args) {

        Optional<String> optionalString = Optional.of("Hello, World!");
        System.out.println(optionalString.get()); // Output: Hello, World!

//        Optional<String> optionalString1 = Optional.of(null);
//        System.out.println(optionalString.get()); // NullPointerException

        List<String> list = Arrays.asList("A", "B", "C");
        Optional<List<String>> optionalList = Optional.of(list);
        System.out.println(optionalList.get()); // Output: [A, B, C]


        Optional<String> emptyOptional = Optional.empty(); //create empty Optional class.
        System.out.println(emptyOptional);

        Optional<String> optNull = Optional.ofNullable(null); // Returns an empty Optional
        Optional<List<String>> optNullable = Optional.ofNullable(list);
        System.out.println(optNull);
        System.out.println(optNullable.get()); //return [A,B,C]



        List<Integer> arrayData = new ArrayList<>(Arrays.asList(10,20,30,40));
        // Correct way to create an Optional of a List
        Optional<List<Integer>> optional = Optional.of(arrayData);

        List<Integer> data = optional
                .map(listdata -> listdata.stream()
                        .filter(a -> a % 3 == 0)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        System.out.println(data);

        System.out.println(optional.get());
        if(optional.isPresent()){
            System.out.println("data is present");
        }
        System.out.println(optional);



        Optional<String> optional1 = Optional.ofNullable(null); // Returns an empty Optional
        System.out.println(optional1);

        Optional<List<Integer>> optional2 = Optional.ofNullable(null);
        System.out.println(optional2);

        System.out.println(optional2.orElseGet(() -> Arrays.asList(0)));

    }
}
