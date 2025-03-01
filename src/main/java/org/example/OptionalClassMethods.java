package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClassMethods {
    public static void main(String[] args) {

        List<Integer> arrayData = new ArrayList<>(Arrays.asList(10,20,30,40));
        // Correct way to create an Optional of a List
        Optional<List<Integer>> optional = Optional.ofNullable(arrayData);
        System.out.println( optional.isPresent()); // if data present it return true

        Optional<List<Integer>> optional1 = Optional.ofNullable(null);
        System.out.println( optional1.isPresent());

        optional.ifPresent(data -> System.out.println(data));

    }
}
