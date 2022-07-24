package com.test.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class exinfo {
	private int ex_seq;
	private String user_id;
	private String ex_name;
	private String ex_kinds;
	private String user_set;
	private String ex_count;
	private String ex_date;
	private String cnt;
}
