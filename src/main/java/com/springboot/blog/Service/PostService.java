package com.springboot.blog.Service;

import java.util.List;

import com.springboot.DTO.PostDTO;

public interface PostService {

	public PostDTO createPost(PostDTO postDT0);
	public List<PostDTO> getAllPost();
}
