package com.munene.userservice.service;

import com.munene.dto.UserDto;
import com.munene.userservice.domain.User;

import java.util.List;

public interface UserService {

    public User create(UserDto userDto);
    public List<User> getAll();
    public User update(UserDto userDto);
    public void delete(UserDto userDto);
}
