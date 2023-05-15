package com.leeeryu.primitive;

import java.time.LocalDate;

public class StringClazz {
    public static void main(String[] args) {
        System.out.println(String.format("Hello %s %<s %1$s", "World"));

        String currentDate = "2023-01-30";

        System.out.println(
                LocalDate.parse(currentDate)
        );
    }
}
