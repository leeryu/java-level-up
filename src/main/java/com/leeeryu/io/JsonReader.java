package com.leeeryu.io;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class JsonReader {
    public static void main(String[] args) {
        DataReader reader = new DataReader();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/data.json",
                Charset.forName("EUC-KR")));
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {

            char[] buffer = new char[1024 * 8];
            int count;
            while ((count = bufferedReader.read(buffer)) != -1) {
                os.write(new String(buffer, 0, count).getBytes());
            }

            List<Person> persons = reader.readToList(os.toByteArray(), Person.class);

            System.out.println(persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person {
    private String userId;
    private String id;
    private String title;
    private String body;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userId='" + userId + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
