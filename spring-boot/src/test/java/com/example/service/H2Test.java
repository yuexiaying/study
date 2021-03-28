package com.example.service;

import com.example.controller.repository.UserRepository;
import com.example.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j

public class H2Test {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${test.name}")
    private String name;



    @Test
    public void test(){
        User user = new User();
        user.setId(1);
        user.setAge(12);
        user.setName("zs");
        userRepository.save(user);
//        user = new User();
//        user.setAge(33);
//        user.setName("ls");
//        userRepository.save(user);
        List<User> all = userRepository.findAll();
        log.info(all.toString());
        log.info(name);
    }
}
