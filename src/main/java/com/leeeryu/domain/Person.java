package com.leeeryu.domain;

public class Person {
	private String name;
	private String auth;

	public Person(String name, String auth) {
		this.name = name;
		this.auth = auth;
	}

	public String getName() {
		return name;
	}

	public String getAuth() {
		return auth;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", auth='" + auth + '\'' +
				'}';
	}
}
