package com.leeeryu.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Person {
	private String name;
	private String auth;
	private int age;
	private double weight;
	private Double height;

	public Person(String name, String auth) {
		this.name = name;
		this.auth = auth;
	}

	public Person(String name, String auth, int age) {
		this.name = name;
		this.auth = auth;
		this.age = age;
	}
}
