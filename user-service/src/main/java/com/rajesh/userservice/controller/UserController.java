package com.rajesh.userservice.controller;

import com.rajesh.userservice.entity.User;
import com.rajesh.userservice.service.UserService;
import com.rajesh.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserByDepartment(@PathVariable("id") Long userId) {
        return userService.getUserByDepartment(userId);
    }

}
