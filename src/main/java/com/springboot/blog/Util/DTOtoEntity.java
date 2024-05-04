package com.springboot.blog.Util;

import com.springboot.DTO.PostDTO;
import com.springboot.blog.Entity.Post;

public class DTOtoEntity {
	public static Post postDTOtoEntity(PostDTO postDTO) {

		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		post.setId(postDTO.getId());
		post.setDescription(postDTO.getDescription());

		return post;

	}
}
