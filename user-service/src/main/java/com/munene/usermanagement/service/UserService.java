package com.munene.usermanagement.service;

import com.munene.dto.UserDto;
import com.munene.usermanagement.domain.User;

import java.util.List;

public interface UserService {

    public User create(UserDto userDto);
    public List<User> getAll();
    public User update(UserDto userDto);
    public void delete(UserDto userDto);
}
