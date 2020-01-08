package com.achan.xiaomi_store.web.controller;

import com.achan.xiaomi_store.model.jpa.entity.ItemTypeEntity;
import com.achan.xiaomi_store.service.main.ItemTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/itemType")
@Api(value = "商品类型接口", tags = "商品类型")
public class ItemTypeController {

    @Autowired
    private ItemTypeService itemTypeService;

    @ApiOperation("获取所有商品类型")
    @GetMapping("/all")
    public List<ItemTypeEntity> allItemTypes() {
        return itemTypeService.getAll();
    }

    @ApiOperation("获取指定id的商品类型")
    @GetMapping("/get/{id}")
    public ItemTypeEntity getOne(@PathVariable int id) {
        return itemTypeService.get(id);
    }
}
