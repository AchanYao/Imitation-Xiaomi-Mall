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
@Entity
@Table(name = "order")
@TableName("order")
@Data
@Accessors(chain = true)
public class OrderEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer addressId;
    private Integer userDetailId;
    @Transient
    private List<ItemEntity> items;
    @Transient
    private transient AddressEntity address;
}
