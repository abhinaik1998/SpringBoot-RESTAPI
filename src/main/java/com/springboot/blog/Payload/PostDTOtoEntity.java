package com.springboot.blog.Payload;

import com.springboot.blog.DTO.PostDTO;
import com.springboot.blog.Entity.Post;

public class PostDTOtoEntity {
	public static Post postDTOtoEntity(PostDTO postDTO) {

		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		post.setId(postDTO.getId());
		post.setDescription(postDTO.getDescription());

		return post;

	}
}
