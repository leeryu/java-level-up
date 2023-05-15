package com.leeeryu.annotate;

import java.lang.reflect.Method;

public class ControllerMain {
    public static void main(String[] args) {
        Controller controller = new Controller();

        try {
            final Method method = controller.getClass().getMethod("get", String.class);
            if (method.isAnnotationPresent(RequestMapping.class)) {
                final RequestMapping annotation = method
                        .getAnnotation(RequestMapping.class);
                System.out.println("value: " + annotation.value() + ", method: " + annotation.method());
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
