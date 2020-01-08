package com.achan.xiaomi_store.dao.repository;

import com.achan.xiaomi_store.model.jpa.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Integer> {

    Optional<ShoppingCartEntity> findByUserId(int userId);
}
