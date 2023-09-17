package com.leeeryu.lamda;

import com.leeeryu.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		people.add(new Person("John", "ADMIN"));
		people.add(new Person("Jane", "ANONYMOUS"));
		people.add(new Person("Doe", "ADMIN"));

		Function<Person, Person> birthdayFunc = p -> {
			p.setAge(p.getAge() + 1);
			return p;
		};

		Function<Person, String> salaryFunc = p -> String.format("%s, %d", p.getName(), p.getAge());

		people.stream().map(birthdayFunc.andThen(salaryFunc)).forEach(System.out::println);
	}
}
