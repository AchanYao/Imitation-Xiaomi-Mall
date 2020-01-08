package com.achan.xiaomi_store.admin.controller;

import com.achan.xiaomi_store.model.jpa.entity.UserEntity;
import com.achan.xiaomi_store.service.main.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Achan
 */
@RestController
@RequestMapping("/api/admin/user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/disabled/:id")
    @ApiOperation("禁用用户")
    public UserEntity disableUser(@PathVariable int id) {
        return userService.disabledUser(id);
    }

    @GetMapping("/count")
    @ApiOperation("获取用户数量")
    public long count() {
        return userService.count();
    }

    @GetMapping("/all")
    @ApiOperation("获取所有用户")
    public List<UserEntity> all() {
        return userService.allUsers();
    }
}
