package com.test.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class deepPostures {
	private int deep_seq;
	private int video_seq;
	private int video_time;
	private String pose_result;
	private String ai_comment;
}
