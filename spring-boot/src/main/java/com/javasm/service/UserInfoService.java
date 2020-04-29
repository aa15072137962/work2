package com.javasm.service;

import com.javasm.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    public UserInfo selectUser(){
        UserInfo user = new UserInfo();
        user.setUsername("宇智波鼬");
        user.setPassword("001");
        return user;
    }
}
