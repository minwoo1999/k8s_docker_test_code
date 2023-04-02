package com.example.dockercomposetest.controller;

import com.example.dockercomposetest.entity.User;
import com.example.dockercomposetest.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "안녕하세요 테스트 성공입니다";
    }
    // 테스트 용이니까 그냥 get으로 받는다
    @GetMapping("/userInsert/{name}")
    public String insertUser(@PathVariable String name){
        System.out.println(name);
        User user=new User();
        user.setName(name);

        userRepository.save(user);
        return "성공";
    }

    @GetMapping("/userList")
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}