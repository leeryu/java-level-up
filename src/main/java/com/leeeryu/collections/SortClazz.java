package com.leeeryu.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SortClazz {
    public static void main(String[] args) {
        final List<Student> students = new ArrayList<>();

        final Random random = new Random();

        for (int i = 0; i < 20; i++) {
            Student s = new Student(String.format("M2023%08d", random.nextInt(99999999)),
                    "상욱",
                    random.nextInt(100), random.nextInt(100)
            );
            students.add(s);
        }
        // 점수 내림차순, 나이 오른차순, 이름 ;
        students.sort(Comparator.comparing(Student::getSeq));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student implements Comparable<Student> {
    private String seq;
    private String name;
    private int age;
    private int score;

    public Student(String seq, String name, int age, int score) {
        this.seq = seq;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getSeq() {
        return seq;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "seq='" + seq + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.getScore() > o.getScore()) {
            return -1;
        } else if (this.getScore() < o.getScore()) {
            return 1;
        } else {
            if (this.getAge() < o.getAge()) {
                return -1;
            } else if (this.getAge() > o.getAge()) {
                return 1;
            } else {
                return this.getName().compareTo(o.getName());
            }
        }
    }
}
