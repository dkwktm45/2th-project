package com.test.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class accessController {
	private String user_id;
	private String ex_day;
	private String timediff;
	private String user_weight;
}