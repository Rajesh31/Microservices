package com.rajesh.userservice.service;

import com.rajesh.userservice.entity.User;
import com.rajesh.userservice.repository.UserRepository;
import com.rajesh.userservice.vo.Department;
import com.rajesh.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }


    public User saveUser(User user) {
        log.info("Inside saveUser of userService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserByDepartment(Long userId) {
        log.info("Inside saveUser of getUserByDepartment");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getUserId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
