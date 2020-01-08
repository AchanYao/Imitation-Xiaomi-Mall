package com.achan.xiaomi_store.dao.repository;

import com.achan.xiaomi_store.model.jpa.entity.CartItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {
    void deleteAllByCartId(int cartId);
    List<CartItems> findAllByCartId(int cartId);
    Page<CartItems> findAllByCartId(int cartId, Pageable pageable);
}
