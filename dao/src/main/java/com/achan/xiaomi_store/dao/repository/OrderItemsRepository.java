package com.achan.xiaomi_store.dao.repository;

import com.achan.xiaomi_store.model.jpa.entity.OrderItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {
    void deleteAllByOrderId(int orderId);

    Page<OrderItems> findAllByOrderId(int orderId, Pageable pageable);

    List<OrderItems> findAllByOrderId(int id);
}
