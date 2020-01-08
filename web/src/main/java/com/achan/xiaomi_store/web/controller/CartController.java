package com.achan.xiaomi_store.web.controller;

import com.achan.xiaomi_store.model.jpa.entity.CartItems;
import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import com.achan.xiaomi_store.model.jpa.entity.ShoppingCartEntity;
import com.achan.xiaomi_store.service.main.CartService;
import com.achan.xiaomi_store.web.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 */
@RestController
@Api(tags = "购物车")
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation("清空购物车")
    @PutMapping("/clear")
    public void clear() {
        cartService.updateCart(new ArrayList<>(), UserUtil.getCurrentUser());
    }

    @ApiOperation("获取购物车商品列表")
    @GetMapping("/list/item")
    public ShoppingCartEntity detail() {
        return cartService.getShoppingCart(UserUtil.getCurrentUser());
    }

    @ApiOperation("分页获取购物车中商品")
    @GetMapping("/page/item")
    public List<ItemEntity> items(int page) {
        return cartService.items(page, UserUtil.getCurrentUser());
    }

    @PostMapping("/update")
    @ApiOperation("更新购物车")
    public void updateCart(@RequestBody List<CartItems> cartItems) {
        cartService.updateCart(cartItems, UserUtil.getCurrentUser());
    }

    @PutMapping("/add")
    @ApiOperation("向购物车中添加商品")
    public void addItem(@RequestParam int itemId, @RequestParam int number) {
        cartService.addItem(itemId, number, UserUtil.getCurrentUser());
    }
}
