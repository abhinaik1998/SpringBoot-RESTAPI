package com.springboot.blog.ServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.DTO.CommentDTO;
import com.springboot.blog.Entity.Comment;
import com.springboot.blog.Entity.Post;
import com.springboot.blog.Exception.UsernotFoundException;
import com.springboot.blog.Payload.CommentMapper;
import com.springboot.blog.Repository.CommentRepo;
import com.springboot.blog.Repository.PostRepository;
import com.springboot.blog.Service.CommentService;

@Service
public class CommentImpl implements CommentService {

	static String username = "root";
	static String password = "root";

	CommentRepo commentrepo;
	PostRepository postrepo;
	ModelMapper modelMapper;

	@Autowired
	public CommentImpl(CommentRepo commentrepo, PostRepository postrepo,ModelMapper modelMapper) {
		this.commentrepo = commentrepo;
		this.postrepo = postrepo;
		this.modelMapper=modelMapper;
	}

	@Override
	public CommentDTO createComment(Long id, CommentDTO commentDTO) {
		//Comment comment = CommentMapper.DTOtoEntity(commentDTO);
		Comment comment=modelMapper.map(commentDTO, Comment.class);
		Post post = postrepo.findById(id).orElseThrow(() -> new UsernotFoundException(id, "post", "id"));
		comment.setPost(post);

		Comment savedcomment = commentrepo.save(comment);
		CommentDTO savedCommentDTO = modelMapper.map(savedcomment, CommentDTO.class);
		return savedCommentDTO;
	}

	@Override
	public List<CommentDTO> getAllComments() {
		List<Comment> commentList = commentrepo.findAll();
		/*
		 * List<CommentDTO> commentDTOList = commentList.stream().map(x ->
		 * CommentMapper.EntitytoDTO(x)) .collect(Collectors.toList());
		 */
		
		//CommentDTO comm=modelMapper.map(commentList,CommentDTO.class );
		List<CommentDTO> commentDTOList = commentList.stream().map(x -> modelMapper.map(x, CommentDTO.class))
				.collect(Collectors.toList());
		return commentDTOList;
	}

	@Override
	public List<CommentDTO> getCommentById(Long id) {
		try {
			Connection conn = getConnection();
			String commentsql = "Select * from comments where post_id=?";
			PreparedStatement st = conn.prepareStatement(commentsql);
			st.setString(1, "1");
			ResultSet result = st.executeQuery();
			System.out.println(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myblog", username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

}
