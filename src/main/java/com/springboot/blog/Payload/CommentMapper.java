package com.springboot.blog.Payload;

import com.springboot.blog.DTO.CommentDTO;
import com.springboot.blog.Entity.Comment;


public class CommentMapper {
	
	public static Comment DTOtoEntity(CommentDTO commentDTO) {
		Comment comment=new Comment();
		comment.setId(commentDTO.getId());
		comment.setEmail(commentDTO.getEmail());
		comment.setName(commentDTO.getName());
		comment.setBody(commentDTO.getBody());
		return comment;
		
	}
	public static CommentDTO EntitytoDTO(Comment comment) {
		CommentDTO commentDTO=new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setEmail(comment.getEmail());
		commentDTO.setName(comment.getName());
		commentDTO.setBody(comment.getBody());
		return commentDTO;
		
	}
	
	

}
