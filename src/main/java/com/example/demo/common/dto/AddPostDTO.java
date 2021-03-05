package com.example.demo.common.dto;

import lombok.Data;

@Data
public class AddPostDTO {
	
	private String title;
	private String content;
	private String imgHeader;
	
	private Long userId;

}
