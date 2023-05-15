package com.leeeryu.generic;

public class BoxMain {
    public static void main(String[] args) {
        final Box<Integer> box = new Box<>();
        box.setData(2);

        print(box.getData());
    }

    public  static <T> void print(T t) {
        System.out.println(t);
    }
}
