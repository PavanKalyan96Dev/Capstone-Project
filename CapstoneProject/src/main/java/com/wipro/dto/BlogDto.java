package com.wipro.dto;


import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BlogDto {
	
	
	private Long id;

	@NotBlank(message = "Title cannot be empty")
	@Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
	private String title;

	@NotBlank(message = "Content cannot be empty")
	@Size(min = 3, max = 200, message = "Content must be between 3 and 200 characters")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogDto other = (BlogDto) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title);
	}

}

