package com.munene.userservice.service.impl;

import com.munene.dto.UserDto;
import com.munene.userservice.domain.User;
import com.munene.userservice.repository.UserRepository;
import com.munene.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setSurName(userDto.getSurName());

        user = this.userRepository.save(user);

        return user;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User update(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setSurName(userDto.getSurName());

        user = this.userRepository.save(user);

        return user;
    }

    @Override
    public void delete(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setSurName(userDto.getSurName());

        this.userRepository.delete(user);

    }
}
