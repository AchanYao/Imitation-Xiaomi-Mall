package com.achan.xiaomi_store.dao.repository;

import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

    @Modifying
    @Query("update ItemEntity set stockQuantity = :num where id = :id")
    void setStockQuantity(@Param("num") int num, @Param("id") int id);

    Page<ItemEntity> findAllByProductNameContains(@Param("keyword") String keyword, Pageable pageable);

    Page<ItemEntity> findAllByProductNameContainsOrDescriptionContains(@Param("p") String p, @Param("d") String d, Pageable pageable);

    List<ItemEntity> findAllByProductNameContains(@Param("p") String p);

    Page<ItemEntity> findAllByTypeId(int typeId, Pageable pageable);
}
