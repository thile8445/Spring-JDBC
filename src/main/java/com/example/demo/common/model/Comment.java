package com.example.demo.common.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
public class Comment extends BaseModel{
	
	private String content;
	
	private Long userId;
	private Long postId;
	@Builder
	public Comment(Long id,String content,Long userId,Long postId,Date created , Date modified) {
		super(id, created, modified);
		this.content = content;
		this.userId = userId;
		this.postId = postId;
	}
	
}
