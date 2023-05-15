package com.leeeryu.io;

import java.io.*;

public class InputStreamExample {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./data/data.json"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./data/data.txt"))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
