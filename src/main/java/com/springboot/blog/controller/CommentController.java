package com.springboot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.DTO.CommentDTO;
import com.springboot.blog.Service.CommentService;
import com.springboot.blog.ServiceImpl.CommentImpl;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentservice;

	@RequestMapping("/getAll")
	public List<CommentDTO> getAllComments() {

		return commentservice.getAllComments();
	}
	@RequestMapping("/getbyId/{postId}")
	public List<CommentDTO> getCommentsByPostID(@PathVariable(value = "postId") Long id) {

		return commentservice.getCommentById(id);
	}


	@RequestMapping("/{postId}/create")
	public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") Long id,
			@RequestBody CommentDTO commentDTO) {

		return new ResponseEntity<>(commentservice.createComment(id, commentDTO), HttpStatus.CREATED);
	}

}
