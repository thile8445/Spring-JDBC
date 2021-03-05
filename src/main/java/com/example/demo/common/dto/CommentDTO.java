package com.example.demo.common.dto;

import lombok.Data;

@Data
public class CommentDTO {

	private String content;
	private Long user_id;
	private Long post_id;
}
