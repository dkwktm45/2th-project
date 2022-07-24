package com.test.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class videoDT {
	private int video_seq;
	private int ex_seq;
	private String file_name;
	private String user_id;
	private String video_date;
}
