package com.leeeryu.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("./data/data.json",
                Charset.forName("EUC-KR")));
             BufferedWriter bw = new BufferedWriter(new FileWriter("./data/data.txt",
                     Charset.forName("EUC-KR")))) {
            char[] buffer = new char[1024];
            int next;
            while ((next = br.read(buffer)) != -1) {
                bw.write(buffer, 0, next);
            }
        }

        char[] cbuf = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("./data/helloworld"), StandardCharsets.UTF_8))) {
            out.write(cbuf, 7, 5);
        }
    }
}
