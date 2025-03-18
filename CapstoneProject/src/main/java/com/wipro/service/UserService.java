package com.wipro.service;

import com.wipro.dto.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userDto);

    Object login(String username, String password);
   
   
}
