package com.leeeryu.regex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RegexExample {
	public static void main(String[] args) {
		// 정규식 으로 자르기
//		String input = "0.7%/kg|+10%";
//
//		System.out.println(Pattern.matches("10", input));
//
//		String s = "21001299000";

//		System.out.println(s.startsWith("2100129000".replaceAll("0+$", "")));
		// 선행탐색
		String input = "aaa1234bbb";
		String regex = "(?=\\d{10})";
		String[] split = input.split(regex);
		final String collect = Arrays.stream(split).collect(Collectors.joining());
		for (String s : split) {
			System.out.println(s);
		}
	}
}
