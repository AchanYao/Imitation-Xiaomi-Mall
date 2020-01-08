package com.achan.xiaomi_store.model.jpa.entity;

import com.achan.xiaomi_store.model.jpa.Auditable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Achan
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "cart_items")
@TableName("cart")
public class CartItems extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cartId;
    private Integer itemId;
    // 商品数量
    @Column(nullable = false)
    private Integer itemNumber;

    @Transient
    private transient ItemEntity item;
}
