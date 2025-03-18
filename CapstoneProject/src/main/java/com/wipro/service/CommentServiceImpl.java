package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.CommentDto;
import com.wipro.entity.CommentEntity;
import com.wipro.exceptions.BlogNotFoundException;
import com.wipro.repository.BlogRepository;
import com.wipro.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentDto postComment(CommentDto commentDto) {
		
		if (!blogRepository.existsById(commentDto.getBlogId())) {
			throw new BlogNotFoundException("Blog not found with ID: " + commentDto.getBlogId());
		}

		CommentEntity commentEntity = mapper.map(commentDto,CommentEntity.class);

		commentEntity = commentRepository.save(commentEntity);

		return mapper.map(commentEntity,CommentDto.class);
	}


}

