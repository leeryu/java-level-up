package com.leeeryu.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderExample {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("./data/data.json"), "EUC-KR"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 한 줄씩 읽은 데이터를 출력
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
