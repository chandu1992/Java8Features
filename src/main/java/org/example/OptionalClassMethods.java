package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClassMethods {
    public static void main(String[] args) {

        List<Integer> arrayData = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        // Correct way to create an Optional of a List

        Optional<List<Integer>> optional = Optional.ofNullable(Arrays.asList(10, 20, 30, 40));
        System.out.println(optional.isPresent()); // if data present it return true

        Optional<List<Integer>> optional1 = Optional.ofNullable(null);
        System.out.println(optional1.isPresent()); // false

        optional.ifPresent(data -> System.out.println(data)); //[10, 20, 30, 40]

        Optional<List<Integer>> mydata = Optional.of(Arrays.asList(10, 11, 12, 13));
        Optional<List<Integer>> mydata1 = Optional.ofNullable(null);

        mydata1.ifPresentOrElse(
                list -> list.forEach(System.out::println),  // [10, 20, 30, 40]
                () -> System.out.println("List is empty")   // List is empty
        );

        Optional<List<Integer>> optionaldata = Optional.ofNullable(Arrays.asList(10, 11, 12, 13));
        optionaldata.orElse(Arrays.asList(0, 1, 2, 3));//[10, 11, 12, 13]

        Optional<List<Integer>> optionaldata1 = Optional.ofNullable(null);
        optionaldata1.orElse(Arrays.asList(0, 1, 2, 3));//[0, 1, 2, 3]


        Optional<List<Integer>> optionalOrElseGet = Optional.ofNullable(Arrays.asList(101, 111, 121, 131));
        List<Integer> newdata = optionalOrElseGet.orElseGet(() -> Arrays.asList(1, 2, 3, 4));
        System.out.println(newdata);//[101, 111, 121, 131]

        Optional<List<Integer>> optionalOrElseGet1 = Optional.ofNullable(null);
        List<Integer> newdata1 = optionalOrElseGet1.orElseGet(() -> Arrays.asList(1, 2, 3, 4));
        System.out.println(newdata1);//[1, 2, 3, 4]


        Optional<List<String>> optionalOrElseGet2 = Optional.ofNullable(Arrays.asList("Gauri", "Chandu", "Pande", "shende"));
        List<String> value = optionalOrElseGet2.orElseThrow(() -> new RuntimeException("Value not found!"));
        System.out.println(value); //[Gauri, Chandu, Pande, shende]

//        Optional<List<String>> optionalOrElseGetThrow = Optional.ofNullable(null);
//        List<String> value1 = optionalOrElseGetThrow.orElseThrow(() -> new RuntimeException("Value not found!"));
//        System.out.println(value); //Exception in thread "main" java.lang.RuntimeException: Value not found!


        Optional<List<String>> optionalOrElseGetThrowNew = Optional.ofNullable(Arrays.asList("me", "you"));
        List<String> getData = optionalOrElseGetThrowNew.get();
        System.out.println(getData); // [me, you]
        Optional<List<String>> optionalGet = Optional.ofNullable(null);
//        System.out.println(optionalGet.get()); //Exception in thread "main" java.util.NoSuchElementException: No value present

        Optional<String> optionalValue = Optional.empty();
        Optional<String> fallbackValue = Optional.of("Fallback");
        Optional<String> result = optionalValue.or(() -> fallbackValue);
        result.ifPresent(System.out::println); // Fallback
    }
}
