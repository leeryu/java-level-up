package com.leeeryu.lamda;

import com.leeeryu.domain.Person;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingObjectExample {
	public static void main(String[] args) {
		final List<Person> persons = Arrays.asList(new Person("Sanguck", "ADMIN")
				, new Person("Alie", "GUEST")
				, new Person("Thome", "GUEST")
				, new Person("G", "GUEST")
				, new Person("Sohee", "GUEST")
		);

		final LinkedHashMap<String, List<Person>> collect = persons.stream()
				.collect(Collectors.groupingBy(Person::getAuth,
						LinkedHashMap::new,
						Collectors.mapping((person) -> person, Collectors.toList())));

		final Set<String> strings = collect.keySet();

		for (Map.Entry<String, List<Person>> entry : collect.entrySet()) {
			System.out.println("key :" + entry.getKey() + " person: " + entry.getValue());
		}
	}
}

