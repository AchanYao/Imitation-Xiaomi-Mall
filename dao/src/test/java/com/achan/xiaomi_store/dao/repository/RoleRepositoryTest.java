package com.achan.xiaomi_store.dao.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void getRoleTest() {
        roleRepository.findAll().forEach(System.out::println);
        System.out.println(roleRepository.getById(1));
    }
}
