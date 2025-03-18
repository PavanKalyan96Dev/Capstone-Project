package com.wipro.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    

    public UserDto() {
    }

    public UserDto(Long id, @NotBlank String username, @NotBlank String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
