package com.springboot.blog.Payload;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.blog.DTO.PostDTO;
import com.springboot.blog.Entity.Post;

public class PostEntitytoDTO {

	@Autowired
	static 	ModelMapper mapper;
	
	public PostEntitytoDTO(ModelMapper mapper) {
		this.mapper=mapper;
	}
	
	public static PostDTO postEntityToDTO(Post post) {

		
		//PostDTO postDto = mapper.map(post, PostDTO.class);
        PostDTO postDto = new PostDTO();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;

	}

	
}
