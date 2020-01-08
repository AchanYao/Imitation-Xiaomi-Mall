package com.achan.xiaomi_store.dao.repository;

import com.achan.xiaomi_store.model.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
}
