package com.achan.xiaomi_store.web.controller;

import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import com.achan.xiaomi_store.service.main.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@Api(tags = "商品")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询所有商品", notes = "分页查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "int", required = true, name = "page", value = "页数", type = "query"),
            @ApiImplicitParam(paramType = "int", required = true, name = "size", value = "每页大小", type = "query")
    }
    )
    @GetMapping("/all")
    public Page<ItemEntity> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return itemService.findAllByPage(pageable);
    }

    @ApiOperation(value = "查询指定类型商品", notes = "分页查询指定类型商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", required = true, name = "page", value = "页数"),
            @ApiImplicitParam(paramType = "query", required = true, name = "size", value = "每页大小"),
            @ApiImplicitParam(paramType = "query", required = true, name = "typeId", value = "类型id")
    }
    )
    @GetMapping("/all/type")
    public Page<ItemEntity> findAllByType(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam int typeId) {
        return itemService.findAllByType(typeId, pageable);
    }

    @ApiOperation(value = "查询商品详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "商品id", paramType = "path"),
    }
    )
    @GetMapping("/detail/{id}")
    public ItemEntity getItem(@PathVariable(name = "id") int id) {
        return itemService.findItemById(id);
    }

    @ApiOperation("通过关键词查找商品")
    @ApiImplicitParam(name = "keyword", required = true, paramType = "query", value = "关键词")
    @GetMapping("/find")
    public Page<ItemEntity> findItemLike(@RequestParam String keyword) {
        return itemService.findAllLike(keyword);
    }

    @GetMapping("/count")
    @ApiOperation("获取商品数量")
    public long count() {
        return itemService.count();
    }
}
