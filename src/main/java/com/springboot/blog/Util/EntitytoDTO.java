package com.springboot.blog.Util;

import com.springboot.DTO.PostDTO;
import com.springboot.blog.Entity.Post;

public class EntitytoDTO {

	public static PostDTO postEntityToDTO(Post post) {

		PostDTO postDTO = new PostDTO();
		postDTO.setContent(post.getContent());
		postDTO.setTitle(post.getTitle());

		postDTO.setDescription(post.getDescription());

		postDTO.setId(post.getId());
		return postDTO;

	}

	public static Post postDTOtoEntity(PostDTO postDTO) {

		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		post.setId(postDTO.getId());
		post.setDescription(postDTO.getDescription());

		return post;

	}
}
