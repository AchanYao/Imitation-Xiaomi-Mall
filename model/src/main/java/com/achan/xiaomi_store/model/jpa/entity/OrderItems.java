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
@Table(name = "order_items")
@TableName("order_items")
public class OrderItems extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderId;
    private int itemId;
    // 商品数量
    @Column(nullable = false)
    private int itemNumber;
}
