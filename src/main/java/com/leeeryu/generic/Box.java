package com.leeeryu.generic;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private T data;
    private ArrayList<String> names = new ArrayList<>();
    private List<? extends Box> boxes = new ArrayList<>();

    public static void setBoxData(Box<?> box) {
        System.out.println("data: " + box.data);
    }
    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public List<? extends Box> getBoxes() {
        return boxes;
    }
}

class NoteBox extends Box {
    NoteBox() {
        super();
    }
}
