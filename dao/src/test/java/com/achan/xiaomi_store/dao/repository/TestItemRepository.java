package com.achan.xiaomi_store.dao.repository;

import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class TestItemRepository {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testSelect() {
        List<ItemEntity> itemEntities = itemRepository.findAll();
        itemEntities.forEach(System.out::println);
    }

    @Test
    public void testFindLike() {
        itemRepository.findAllByProductNameContains("小米", PageRequest.of(0, 10)).forEach(System.out::println);
    }

    @Test
    public void testFindAllLike() {
        itemRepository
                .findAllByProductNameContainsOrDescriptionContains("小米", "小米", PageRequest.of(0, 10))
                .forEach(System.out::println);
    }

    @Test
    public void testFindAllNameLike() {
        itemRepository
                .findAllByProductNameContains("小米")
                .forEach(System.out::println);
    }
}
