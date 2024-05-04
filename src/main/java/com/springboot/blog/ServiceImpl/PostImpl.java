package com.springboot.blog.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.DTO.PostDTO;
import com.springboot.blog.Entity.Post;
import com.springboot.blog.Repository.PostRepository;
import com.springboot.blog.Service.PostService;
import com.springboot.blog.Util.DTOtoEntity;
import com.springboot.blog.Util.EntitytoDTO;

@Service
public class PostImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<PostDTO> getAllPost() {
		List<PostDTO> allDTOPosts=new ArrayList<>();
		List<Post> allPosts = postRepository.findAll();
		return allPosts.stream().map(x->EntitytoDTO.postEntityToDTO(x)).collect(Collectors.toList());
//		for(int i=0;i<=allPosts.size()-1;i++) {
//			allDTOPosts.add( EntitytoPostDTO.postEntityToDTO(allPosts.get(i)));}
		 
	}

	@Override
	public PostDTO createPost(PostDTO postDT0) {

		return EntitytoDTO.postEntityToDTO(postRepository.save(DTOtoEntity.postDTOtoEntity(postDT0)));
	}

}
