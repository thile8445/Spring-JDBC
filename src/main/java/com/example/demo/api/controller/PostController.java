package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.dao.PostDAO;
import com.example.demo.commom.exception.PostException;
import com.example.demo.common.dto.AddPostDTO;
import com.example.demo.common.model.Post;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostDAO postDao ;
	
	@GetMapping("")
	public List<Post> getAllPost() {
		return postDao.getAllPost();
	}
	@GetMapping("/{id}")
	public Post getPostByid(@PathVariable(name = "id")Long id) {
		return postDao.getPostById(id);
	}
	@PostMapping("")
	public int addPost(@RequestBody AddPostDTO post) throws PostException {
		return postDao.addPost(post);
	}
	@PutMapping("/{id}")
	public int updatePost(@PathVariable(name = "id")Long id,@RequestBody AddPostDTO post) throws PostException{
		return postDao.updatePost(id, post);
	}
	@DeleteMapping("/{id}")
	public int deletePost(@PathVariable(name = "id")Long id) throws PostException{
		return postDao.deletePost(id);
	}
}