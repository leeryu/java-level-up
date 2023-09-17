package com.leeeryu.lamda;

import com.leeeryu.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("John", "ADMIN"));
		people.add(new Person("Jane", "ANONYMOUS"));
		people.add(new Person("Doe", "ADMIN"));

		// Consumer를 사용하여 각 Person 객체를 출력하는 예제
		Consumer<Person> weight = p -> p.setWeight(p.getWeight() + 1);
		Consumer<Person> height = p -> p.setHeight(p.getHeight() + 1);
		Consumer<Person> print = System.out::println;

		// Consumer를 사용하여 각 Person 객체의 나이를 1씩 증가시키는 예제
		Consumer<Person> birthday = p -> p.setAge(p.getAge() + 1);
		Consumer<Person> doubleValueInit = p -> {
			if (Objects.isNull(p.getHeight())) {
				p.setHeight(0.0);
			} else {
				p.setHeight(p.getHeight() * 2);
			}
		};

		// people 리스트의 각 요소에 대해 Consumer를 적용
		people.forEach(birthday
				.andThen(doubleValueInit)
				.andThen(weight)
				.andThen(height)
				.andThen(print)
		);
	}
}
