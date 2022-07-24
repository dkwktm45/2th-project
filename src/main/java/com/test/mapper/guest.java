package com.test.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class guest {
	private int user_id;
	private String user_name;
	private String user_phone;
	private String user_gym;
	private String user_expire_date;
	private String user_birthdate;
	private String contents;
	private String day;
	private String time;
	private int manager_yn;
	private String ad_comment;
	private int month;
}
