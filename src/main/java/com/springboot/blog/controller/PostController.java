package com.springboot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.DTO.PostDTO;
import com.springboot.blog.Entity.Post;
import com.springboot.blog.Payload.PostResponse;
import com.springboot.blog.Service.PostService;
import com.springboot.blog.Util.AppConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {
	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// @RequestMapping(value = "/getAll",method = RequestMethod.GET )
	@GetMapping("/getAll")
	public PostResponse getAllPost(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.default_page_no, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.default_page_size, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.default_sort_by, required = false) String sortBy,
			@RequestParam(value = "sortType", defaultValue = AppConstants.default_sort_dir, required = false) String sortType) {
		return postService.getAllPost(pageNo, pageSize, sortBy, sortType);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id", required = true) Long id) {
		return new ResponseEntity<PostDTO>(postService.getPostById(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity createPost(@Valid @RequestBody PostDTO postDTO) {
		System.out.println(postDTO);
		return new ResponseEntity(postService.createPost(postDTO), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PostDTO> updatePostById(@PathVariable(name = "id") Long id, @RequestBody PostDTO postDTO) {
		return new ResponseEntity<PostDTO>(postService.updatePostById(id, postDTO), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity deletePost(@PathVariable Long id) {
		postService.deletePost(id);
		return new ResponseEntity<>("ID:" + id + " post Deleted ", HttpStatus.OK);
	}
}
