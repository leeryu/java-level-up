package com.leeeryu.exceptions;

import java.net.ConnectException;

public class ExceptionMainClazz {
    public static void main(String[] args) {
        try {
            throw new ConnectException("ConnectException");
        } catch (ConnectException e) {
            System.out.println("Connect db failed!");
        } finally {
            System.out.println("Good bye!");
        }
    }
}
