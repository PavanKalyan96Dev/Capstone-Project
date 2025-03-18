package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.BlogDto;
import com.wipro.dto.CommentDto;
import com.wipro.exceptions.BlogNotFoundException;
import com.wipro.service.BlogService;
import com.wipro.service.CommentService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/blogs")
@Validated
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CommentService commentService;

	
	@PostMapping
	public ResponseEntity<BlogDto> createBlog(@Valid @RequestBody BlogDto blogDto) {
		BlogDto createdBlog = blogService.createBlog(blogDto);
		return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<BlogDto> getBlogById(@PathVariable Long id) {
		BlogDto blogDto = blogService.getBlogById(id);
		return new ResponseEntity<>(blogDto, HttpStatus.OK);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<BlogDto> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogDto blogDto) {
		BlogDto updatedBlog = blogService.updateBlog(id, blogDto);
		return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
		boolean isDeleted = blogService.deleteBlog(id);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}

	
	@PostMapping("/comment")
	public ResponseEntity<CommentDto> postComment(@Valid @RequestBody CommentDto commentDto) {
		CommentDto postedComment = commentService.postComment(commentDto);
		return new ResponseEntity<>(postedComment, HttpStatus.OK);
	}

	
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<String> handleBlogNotFoundException(BlogNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}




