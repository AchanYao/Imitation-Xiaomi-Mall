package com.achan.xiaomi_store.web.controller;

import com.achan.xiaomi_store.model.jpa.entity.OrderEntity;
import com.achan.xiaomi_store.service.main.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Api(tags = "订单")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "获取订单细节")
    @ApiImplicitParam(name = "id", required = true, paramType = "path", value = "订单id")
    @GetMapping("/detail/{id}")
    public OrderEntity getOrder(@PathVariable(name = "id") int id) {
        return orderService.getFullOrderEntity(id);
    }

    @ApiOperation(value = "获取用户所有订单")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "userId", value = "用户id", paramType = "form"),
            @ApiImplicitParam(required = true, name = "page", value = "页数", paramType = "form"),
            @ApiImplicitParam(required = true, name = "size", value = "页面大小", paramType = "form")
    }
    )
    @GetMapping("/find")
    public Page<OrderEntity> showOrdersByUser(@RequestParam int userId, @RequestParam int page, @RequestParam int size) {
        return orderService.getOrders(userId, PageRequest.of(page, size));
    }
}
