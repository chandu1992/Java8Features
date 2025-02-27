package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        Optional<String> emptyOptional = Optional.empty(); //create empty Optional class.
        System.out.println(emptyOptional);

        List<Integer> arrayData = new ArrayList<>(Arrays.asList(10,20,30,40));
        // Correct way to create an Optional of a List
        Optional<List<Integer>> optional = Optional.of(arrayData);
        System.out.println(optional);

        Optional<String> optional1 = Optional.ofNullable(null); // Returns an empty Optional
        System.out.println(optional1);

        Optional<List<Integer>> optional2 = Optional.ofNullable(null);
        System.out.println(optional2);

        System.out.println(optional2.orElseGet(() -> Arrays.asList(0)));

    }
}
