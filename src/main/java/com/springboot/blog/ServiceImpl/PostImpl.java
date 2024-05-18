package com.springboot.blog.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.blog.DTO.PostDTO;
import com.springboot.blog.Entity.Post;
import com.springboot.blog.Exception.UsernotFoundException;
import com.springboot.blog.Payload.PostDTOtoEntity;
import com.springboot.blog.Payload.PostEntitytoDTO;
import com.springboot.blog.Payload.PostResponse;
import com.springboot.blog.Repository.PostRepository;
import com.springboot.blog.Service.PostService;

import ch.qos.logback.core.model.Model;

@Service
public class PostImpl implements PostService {


	private PostRepository postRepository;
	private ModelMapper modelMapper;
	@Autowired
	public PostImpl(PostRepository postRepository, ModelMapper modelMapper) {
		super();
		this.postRepository = postRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortType) {
		// pagination
		// Pageable pageable = PageRequest.of(pageNo, pageSize);
		Pageable pageable = null;

		// pagination with sorting
		if (sortType.equalsIgnoreCase("asc")) {
			pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		}
		if(sortType.equalsIgnoreCase("desc")) {
			pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		}
		
//		Sort sort = sortType.equalsIgnoreCase(Sort.Direction.ASC.toString()) ? Sort.by(sortType) : Sort.by(sortType);
//		pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Post> postPage = postRepository.findAll(pageable);

		// getting content from page
		List<Post> allPosts = postPage.getContent();

		List<PostDTO> content = allPosts.stream().map(x -> PostEntitytoDTO.postEntityToDTO(x)).collect(Collectors.toList());
		PostResponse postResponse = new PostResponse(postPage.getNumber(), postPage.getSize(),
				postPage.getTotalElements(), postPage.getTotalPages(), postPage.isLast(), content);
//		PostResponse postResponse = new PostResponse();
//		postResponse.setPageNo(postPage.getNumber());
//		postResponse.setPageSize(postPage.getSize());
//		postResponse.setTotalElement(postPage.getTotalElements());
//		postResponse.setTotalpages(postPage.getTotalPages());
//		postResponse.setLastPage(postPage.isLast());
//		postResponse.setContent(content);

//      for(int i=0;i<=allPosts.size()-1;i++) {
//		allDTOPosts.add( EntitytoPostDTO.postEntityToDTO(allPosts.get(i)));}
		return postResponse;
	}

	@Override
	public PostDTO createPost(PostDTO postDT0) {
		System.out.println(postDT0);
		Post post = modelMapper.map(postDT0, Post.class);
		Post savedPost=postRepository.save(post);
		System.out.println(savedPost);
		PostDTO returnDTO = modelMapper.map(  savedPost,PostDTO.class);
		return returnDTO;
		//return PostEntitytoDTO.postEntityToDTO(postRepository.save(PostDTOtoEntity.postDTOtoEntity(postDT0)));
	}

	@Override
	public PostDTO getPostById(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new UsernotFoundException(id, "Post", "id"));
		//return modelMapper.map(post, PostDTO.class);
		return PostEntitytoDTO.postEntityToDTO(post);
	}

	

	

	@Override
	public PostDTO updatePostById(Long id, PostDTO postDTO) {

		Post Existingpost = postRepository.findById(id).orElseThrow(() -> new UsernotFoundException(id, "Post", "id"));
		Existingpost.setContent(postDTO.getContent());
		Existingpost.setDescription(postDTO.getDescription());

		Existingpost.setTitle(postDTO.getTitle());
		Post updatedpost = postRepository.save(Existingpost);

		return PostEntitytoDTO.postEntityToDTO(updatedpost);

	}

	@Override
	public void deletePost(Long id) {
		postRepository.findById(id).orElseThrow(() -> new UsernotFoundException(id, "Post", "id"));
		postRepository.deleteById(id);
	}

}
