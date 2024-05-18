package com.springboot.blog.Service;

import java.util.List;

import com.springboot.blog.DTO.PostDTO;
import com.springboot.blog.Entity.Post;
import com.springboot.blog.Payload.PostResponse;

public interface PostService {

	public PostDTO createPost(PostDTO postDT0);
	public PostResponse getAllPost(int PageNo,int pageSize, String sortBy, String sortType);
	public PostDTO getPostById(Long id);
	public PostDTO updatePostById(Long id,PostDTO postDTO);
	public void deletePost(Long id);

}
