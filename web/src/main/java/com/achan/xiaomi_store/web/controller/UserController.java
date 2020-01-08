package com.achan.xiaomi_store.web.controller;

import com.achan.xiaomi_store.model.jpa.entity.UserDetailEntity;
import com.achan.xiaomi_store.model.jpa.entity.UserEntity;
import com.achan.xiaomi_store.service.main.UserDetailService;
import com.achan.xiaomi_store.web.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailService userDetailService;

    @ApiOperation("获取用户详细信息")
    @GetMapping("/detail")
    public UserDetailEntity getDetail() {
        UserEntity currentUser = UserUtil.getCurrentUser();
        return userDetailService.getUserDetail(currentUser.getId());
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/detail/put")
    public void updateUser(@RequestBody UserDetailEntity detail) {
        userDetailService.updateUserDetail(UserUtil.getCurrentUser(), detail);
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public UserEntity userRegister(String username, String password) {
        return userDetailService.userRegister(new UserEntity().setUsername(username).setPassword(passwordEncoder.encode(password)));
    }

    @PostMapping("/current")
    @ApiOperation("获取当前用户")
    public UserEntity currentUser() {
        return UserUtil.getCurrentUser();
    }
}
