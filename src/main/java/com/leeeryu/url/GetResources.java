package com.leeeryu.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static java.nio.charset.StandardCharsets.UTF_8;

public class GetResources {
    public static void main(String[] args) {
        try {
            URLConnection connection = new URL("http://worldtimeapi.org/api/timezone/etc/UTC.txt").openConnection();
            try (final BufferedReader buffReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), UTF_8))) {
                String line;
                while ((line = buffReader.readLine()) != null) {
                    if (line.startsWith("datetime")) {
                        System.out.println(line.trim());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("[ERROR][open connection url] " + e.getMessage());
        }
    }
}
