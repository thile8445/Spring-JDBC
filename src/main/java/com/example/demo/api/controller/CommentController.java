package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.dao.CommentDAO;
import com.example.demo.common.dto.GetCommentDTO;
import com.example.demo.common.model.Comment;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentDAO comment;
	
	@GetMapping("/all")
	public List<Comment>  getAllComment() {
		return comment.getAllComment();
	}
	@GetMapping("")
	public List<Comment> getAllByUserAndPost(@RequestBody GetCommentDTO getComment){
		return comment.getCommentByPostAndUser(getComment.getUserId(), getComment.getPostId());
	}
}
