package com.leeeryu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Person {
	private String name;
	private String auth;
	private int age;
	private double weight;
	private Double height;
	private List<Car> cars;

	public Person(String name, String auth) {
		this.name = name;
		this.auth = auth;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.cars = new ArrayList<>();
	}

	public Person(String name, String auth, int age) {
		this.name = name;
		this.auth = auth;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", auth='" + auth + '\'' +
				", age=" + age +
				", weight=" + weight +
				", height=" + height +
				", cars=" + cars +
				", car size=" + (cars == null ? 0 : cars.size()) +
				'}';
	}
}
