package com.leeeryu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Car {
	private String carNm;
	private String carColor;
	private int carYear;
}
