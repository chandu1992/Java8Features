package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClassMethods {
    public static void main(String[] args) {

        List<Integer> arrayData = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        // Correct way to create an Optional of a List
        Optional<List<Integer>> optional = Optional.ofNullable(arrayData);
        System.out.println(optional.isPresent()); // if data present it return true

        Optional<List<Integer>> optional1 = Optional.ofNullable(null);
        System.out.println(optional1.isPresent()); // false

        optional.ifPresent(data -> System.out.println(data)); //[10, 20, 30, 40]

        Optional<List<Integer>> mydata = Optional.of(Arrays.asList(10, 11, 12, 13));
        Optional<List<Integer>> mydata1 = Optional.ofNullable(null);


        // Using ifPresentOrElse correctly
        mydata1.ifPresentOrElse(
                list -> list.forEach(System.out::println),  // Consumer<T> (runs if value is present)
                () -> System.out.println("List is empty")   // Runnable (runs if value is empty)
        );

        Optional<List<Integer>> optionaldata = Optional.ofNullable(Arrays.asList(10, 11, 12, 13));
        optionaldata.orElse(Arrays.asList(0, 1, 2, 3));//[10, 11, 12, 13]

        Optional<List<Integer>> optionaldata1 = Optional.ofNullable(null);
        optionaldata1.orElse(Arrays.asList(0, 1, 2, 3));//[0, 1, 2, 3]


        Optional<List<Integer>> optionalOrElseGet = Optional.ofNullable(Arrays.asList(101, 111, 121, 131));
        List<Integer> newdata =  optionalOrElseGet.orElseGet(()->Arrays.asList(1,2,3,4));
        System.out.println(newdata);//[101, 111, 121, 131]

        Optional<List<Integer>> optionalOrElseGet1 = Optional.ofNullable(null);
        List<Integer> newdata1 =  optionalOrElseGet1.orElseGet(()->Arrays.asList(1,2,3,4));
        System.out.println(newdata1);//[1, 2, 3, 4]
    }
}
