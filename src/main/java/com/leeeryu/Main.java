package com.leeeryu;

import com.leeeryu.io.DataReader;
import com.leeeryu.url.UrlConnector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UrlConnector connector = new UrlConnector();
        final DataReader reader = new DataReader();

        final String responseData = connector.get("https://jsonplaceholder.typicode.com/posts", null);
        System.out.println(responseData);
    }
}
