package com.javasm.handler;

import com.javasm.entity.UserInfo;
import com.javasm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoHandler {
    @Autowired
    private UserInfoService userInfoService;
   @GetMapping
    public UserInfo query() {
        return userInfoService.selectUser();

    }
}
