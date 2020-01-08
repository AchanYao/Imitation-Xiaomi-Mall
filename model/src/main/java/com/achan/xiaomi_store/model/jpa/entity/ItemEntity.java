package com.achan.xiaomi_store.model.jpa.entity;

import com.achan.xiaomi_store.model.jpa.Auditable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 商品实体
 * @author Achan
 */
@Entity
@Table(name = "items")
@Data
@Accessors(chain = true)
@TableName("items")
public class ItemEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 商品描述
    @Column(nullable = false, length = 500)
    @NotNull
    @NotBlank
    private String description;
    // 商品价格
    @Column(nullable = false, length = 10)
    private Double price;
    // 商品数量
    @Column(nullable = false, length = 10)
    private Integer stockQuantity;
    // 商品图片
    @Column(nullable = false, length = 150)
    @NotBlank
    @NotNull
    private String picUrl;
    @Column(nullable = false, length = 50)
    @NotBlank
    @NotNull
    private String productName;
    @Column(nullable = false, length = 11)
    private Integer typeId;
    @Transient
    private transient ItemTypeEntity itemTypeEntity;
}
