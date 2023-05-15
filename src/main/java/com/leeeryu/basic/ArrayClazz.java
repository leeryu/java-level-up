package com.leeeryu.basic;

import java.util.Arrays;

public class ArrayClazz {
    public static void main(String[] args) {
        final String[] fruits = {"apple", "banana", "orange", "apple"};

        Arrays.parallelSort(fruits);

        System.out.println(Arrays.toString(fruits));
    }
}
