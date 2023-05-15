package com.leeeryu.primitive;


import java.util.StringTokenizer;

public class StringToken {
    public static void main(String[] args) {
        String name = "lee sang uck";

        // java version 12
        name.chars().forEach(c -> System.out.println(Character.toString(c)));

        // java version 1.0 <=
        final StringTokenizer st = new StringTokenizer(name);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        // 1.0 <=
        final String[] split = name.split("");
//        for (String s : split) {
//            System.out.println(s);
//        }

        // every character
        final char[] chars = name.toCharArray();
//        for (char c : chars) {
//            System.out.print(Character.valueOf(c));
//        }
    }
}
