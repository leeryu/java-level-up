package com.leeeryu.lamda;

import com.leeeryu.domain.Car;
import com.leeeryu.domain.Person;

import java.util.*;
import java.util.stream.Collectors;

public class MergeExample {
	public static void main(String[] args) {
		// 이름 나이 자동차명 색상 구입년도
		final Map<String, String> data1 = new HashMap<>();
		data1.put("name", "이상욱");
		data1.put("age", "39");
		data1.put("carNm", "아반테");
		data1.put("carColor", "검정");
		data1.put("carYear", "2014");

		final Map<String, String> data2 = new HashMap<>();
		data2.put("name", "이상욱");
		data2.put("age", "39");
		data2.put("carNm", "i30");
		data2.put("carColor", "청색");
		data2.put("carYear", "2019");

		final Map<String, String> data3 = new HashMap<>();
		data3.put("name", "이민욱");
		data3.put("age", "39");
		data3.put("carNm", "niro");
		data3.put("carColor", "녹색");
		data3.put("carYear", "2018");

		final Map<String, String> data4 = new HashMap<>();
		data4.put("name", "류두례");
		data4.put("age", "64");

		final List<Map<String, String>> datas = Arrays.asList(data1, data2, data3, data4);

		final List<Person> persons = datas.stream()
				.map((data) -> new Person(data.get("name"), Integer.parseInt(data.get("age"))))
				.collect(Collectors.toMap(Person::getName, (person) -> person,
						(v1, v2) -> v1, LinkedHashMap::new))
				.values()
				.stream()
				.peek((person) -> person.setCars(
						datas.stream()
								.filter((data) -> person.getName().equals(data.get("name")))
								.filter((data) -> data.get("carNm") != null)
								.map((data) -> new Car(data.get("carNm"), data.get("carColor"),
										Integer.parseInt(data.get("carYear"))))
								.collect(Collectors.toList())
				)).collect(Collectors.toList());

		System.out.println(persons);
	}
}
