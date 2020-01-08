package com.achan.xiaomi_store.dao.repository;

import com.achan.xiaomi_store.model.jpa.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Integer> {

    UserDetailEntity findByUserId(int userId);
}
