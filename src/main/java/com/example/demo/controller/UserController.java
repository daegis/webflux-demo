package com.example.demo.controller;

import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 8/20/2018 2:20 PM
 */
@Slf4j
@RestController
public class UserController {

    @PostMapping("/user/save")
    public User saveUser(String name) {
        User user = new User();
        user.setName(name);
        user.setId(1);
        return user;
    }
}
