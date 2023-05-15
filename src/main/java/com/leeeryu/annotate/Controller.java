package com.leeeryu.annotate;

public class Controller {

    @RequestMapping(value = "/get", method = "GET")
    public String get(String id) {
        return "get " + id;
    }
}
