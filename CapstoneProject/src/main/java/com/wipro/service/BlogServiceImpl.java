package com.wipro.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.BlogDto;
import com.wipro.entity.BlogEntity;
import com.wipro.exceptions.BlogNotFoundException;
import com.wipro.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public BlogDto createBlog(BlogDto blogDto) {
		
		BlogEntity blogEntity = mapper.map(blogDto,BlogEntity.class);
		
		blogEntity = blogRepository.save(blogEntity);
		
		return mapper.map(blogEntity,BlogDto.class);
	}

	@Override
	public BlogDto getBlogById(Long id) {
		
		BlogEntity blogEntity = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));
	
		return  mapper.map(blogEntity,BlogDto.class);
	}

	@Override
	public BlogDto updateBlog(Long id, BlogDto blogDto) {
		
		BlogEntity existingBlog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

		
		existingBlog.setTitle(blogDto.getTitle());
		existingBlog.setContent(blogDto.getContent());

		
		existingBlog = blogRepository.save(existingBlog);

		
		return mapper.map(existingBlog,BlogDto.class);
	}

	@Override
	public Boolean deleteBlog(Long id) {
		Optional<BlogEntity> blogEntity = blogRepository.findById(id);
		if (blogEntity.isPresent()) {
			
			blogRepository.deleteById(id);
			return true;			
		}
		throw new BlogNotFoundException("Blog not found with ID: " + id);		
	}

	
	
}

