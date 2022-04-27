package com.munene.userservice.controller;

import com.munene.dto.UserDto;
import com.munene.userservice.domain.User;
import com.munene.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto){
        User user = this.userService.create(userDto);
        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        List<User> users = this.userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserDto userDto){
        User user = this.userService.create(userDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity<User> delete(@RequestBody UserDto userDto){
        this.userService.delete(userDto);
        return ResponseEntity.ok().build();
    }
}
