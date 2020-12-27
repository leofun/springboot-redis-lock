package com.example.basespringboot.service.impl;

import com.example.basespringboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void sayHello() {
        System.out.println("hahahah");
    }

}
