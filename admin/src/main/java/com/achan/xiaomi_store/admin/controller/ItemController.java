package com.achan.xiaomi_store.admin.controller;

import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import com.achan.xiaomi_store.service.exception.IncompleteEntityException;
import com.achan.xiaomi_store.service.main.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Achan
 */
@RestController
@RequestMapping("/api/admin/items")
@Api(tags = "商品")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PutMapping("/add")
    @ApiOperation("增加商品")
    public void addItem(@RequestBody @Validated ItemEntity itemEntity) throws IncompleteEntityException {
        itemService.saveItem(itemEntity);
    }

    @DeleteMapping("/delete/:id")
    @ApiOperation("删除商品")
    public void deleteItem(@PathVariable int id) {
        itemService.delete(id);
    }

    @PostMapping("/update")
    @ApiOperation("修改商品")
    public void updateItem(@RequestBody @Validated ItemEntity itemEntity) throws IncompleteEntityException {
        itemService.updateItem(itemEntity);
    }
}
