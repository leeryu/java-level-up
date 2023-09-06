package com.leeeryu.lamda;

import java.util.Optional;
import java.util.stream.Stream;

public class FlatMapOptionalExample {
	public static void main(String[] args) {
		Optional<String> optionalValue = Optional.of("Hello");

		Stream<char[]> charStream = optionalValue.stream()
				.flatMap(value -> Stream.of(value.toCharArray())); // Flattening char array

		charStream.forEach(System.out::println);
	}
}
