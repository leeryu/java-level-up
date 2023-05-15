package com.leeeryu.lamda;

import java.util.Arrays;

public class ArrayClazz {
    public static void main(String[] args) {
        int[] ages = new int[0];

        Arrays.fill(ages, 20);

        System.out.println(Arrays.toString(ages));
    }
}
