package com.achan.xiaomi_store.model.jpa.entity;

import com.achan.xiaomi_store.model.jpa.Auditable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * @author Achan
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "shopping_cart")
@TableName("shopping_cart")
public class ShoppingCartEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    @Transient
    private transient List<CartItems> items;
}
