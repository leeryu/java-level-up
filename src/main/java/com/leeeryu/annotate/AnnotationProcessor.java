package com.leeeryu.annotate;


import java.lang.reflect.Field;

public class AnnotationProcessor {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Leeeryu");
        person.setAge(18);
        person.setAddress("Korea");

        // Person 클래스에 JsonSerializable 어노테이션이 적용되었는지 확인하기
        if (person.getClass().isAnnotationPresent(JsonSerializable.class)) {
            String json = convertToJson(person);

            System.out.println(json);
        }
    }

    private static String convertToJson(Object o) {
        // 객체의 필드들을 가져오기
        final Field[] fields = o.getClass().getDeclaredFields();
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        for (Field field : fields) {
            builder.append("\"").append(field.getName()).append("\"").append(":");
            try {
                builder.append("\"").append(field.get(o)).append("\"").append(",");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");

        return builder.toString();
    }
}
