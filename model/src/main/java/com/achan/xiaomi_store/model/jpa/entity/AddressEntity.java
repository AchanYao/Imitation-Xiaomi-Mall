package com.achan.xiaomi_store.model.jpa.entity;

import com.achan.xiaomi_store.model.jpa.Auditable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Achan
 */
@Entity
@Table(name = "address")
@Data
@Accessors(chain = true)
@TableName("address")
public class AddressEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false, length = 11)
    private String phone;
    private Integer userDetailId;
}
