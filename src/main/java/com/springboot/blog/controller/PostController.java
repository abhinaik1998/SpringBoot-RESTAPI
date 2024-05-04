package com.springboot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.DTO.PostDTO;
import com.springboot.blog.Service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService=postService;
	}
	
	//@RequestMapping(value = "/getAll",method = RequestMethod.GET )
	@GetMapping("/get")
	public List<PostDTO> getAllPost() {
		return postService.getAllPost();
	}
	
	
	@PostMapping("/create")
	public ResponseEntity createPost(@RequestBody PostDTO postDTO) {
		return new ResponseEntity( postService.createPost(postDTO),HttpStatus.CREATED);
	}

	
}
