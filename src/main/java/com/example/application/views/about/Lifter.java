package com.example.application.views.about;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lifter {

	private Integer id;
	private Integer lot;
	private String name;
	private Integer birthYear;

}
