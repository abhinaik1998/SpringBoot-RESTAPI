package com.springboot.blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.blog.Entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {
	
}
