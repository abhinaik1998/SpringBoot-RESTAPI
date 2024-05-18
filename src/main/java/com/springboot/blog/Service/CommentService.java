package com.springboot.blog.Service;

import java.util.List;

import com.springboot.blog.DTO.CommentDTO;

public interface CommentService {

	public CommentDTO createComment(Long id,CommentDTO commentDTO) ;
	public List<CommentDTO> getAllComments();
	public List<CommentDTO> getCommentById(Long postID);
}
