package com.example.demo.common.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseModel{
	
	private String title;
	private String content;
	private String imgHeader;
	
	private Long userId;
	
	@Builder
	public Post(Long id, String title,String content,String imgHeader,Long userId,Date created,Date modified) {
		super(id,created,modified);
		this.title = title;
		this.content = content;
		this.imgHeader = imgHeader;
		this.userId = userId;
	}

}
