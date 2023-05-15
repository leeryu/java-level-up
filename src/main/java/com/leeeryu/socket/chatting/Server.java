package com.leeeryu.socket.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started: " + serverSocket);
            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Sender extends Thread {
        private DataOutputStream dos;
        private Socket socket;
        private String name;

        public Sender(Socket socket) {
            this.socket = socket;

            try {
                dos = new DataOutputStream(socket.getOutputStream());
                name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    String message = scanner.nextLine();
                    dos.writeUTF(name + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Receiver extends Thread {
        Socket socket;
        DataInputStream in;

        Receiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
