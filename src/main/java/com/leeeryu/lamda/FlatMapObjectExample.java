package com.leeeryu.lamda;

import com.leeeryu.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapObjectExample {
	public static void main(String[] args) {
		List<List<Person>> peopleLists = new ArrayList<>();
		peopleLists.add(Arrays.asList(new Person("Alice", "ADMIN"), new Person("Bob", "GUEST")));
		peopleLists.add(Arrays.asList(new Person("Charlie", "GUEST"), new Person("David", "GUEST")));

		Stream<String> namesStream = peopleLists.stream()
				.flatMap(list -> list.stream())
				.map(Person::getName); // Flattening and extracting names

		namesStream.forEach(System.out::println);
	}
}

