package com.leeeryu.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            final Socket localhost = new Socket("localhost", 8080);

            if (localhost.isConnected()) {
                System.out.println("Connected to server: " + localhost);
            } else {
                throw new RuntimeException("Failed to connect to server: " + localhost);
            }

            while (true) {
                System.out.print("Enter messag: ");
                final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                final String message = br.readLine();

                if ("".equals(message.trim())) {
                    System.out.println("전송할 메시지를 입력해 주세요.");
                } else if ("exit".equals(message.trim())) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    localhost.getOutputStream().write(message.getBytes());
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to connect to server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
