package com.leeeryu.primitive;

import java.util.ArrayList;
import java.util.List;

public class StringArray {
    public static void main(String[] args) {
        final String[] names = new String[100];

        final String[] copyNames = names; // call by reference

        for (int i = 0; i < 100; i++) {
            names[i] = "Leeeryu" + i;
        }

        copyNames[0] = "REPLACED";

        int[] ints = new int[100_000_000];
        List<Integer> integers = new ArrayList<>(100_000_000);

        for (int i = 0; i < 100_000_000; i++) {
            ints[i] = i;
            integers.add(i);
        }

        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            {
                int j = 0;
                while (j < ints.length) {
                    j++;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("Array");
            System.out.println((i + 1) + "회차: " + (end - start));

            long start1 = System.currentTimeMillis();
            int j = 0;
            while (j < integers.size()) {
                j++;
            }
            long end1 = System.currentTimeMillis();

            System.out.println("ArrayList");
            System.out.println((i + 1) + "회차: " + (end1 - start1));

            System.out.println();
        }
    }
}
