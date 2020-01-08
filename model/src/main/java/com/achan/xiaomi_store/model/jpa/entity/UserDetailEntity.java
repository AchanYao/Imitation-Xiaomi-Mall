package com.achan.xiaomi_store.model.jpa.entity;

import com.achan.xiaomi_store.model.jpa.Auditable;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * @author Achan
 */
@Entity
@Table(name = "user_detail")
@Data
@Accessors(chain = true)
public class UserDetailEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    @TableField(insertStrategy = FieldStrategy.IGNORED, updateStrategy = FieldStrategy.NOT_EMPTY)
    private String email;
    @Column(length = 10)
    private String realName;
    @Column(nullable = false, length = 10)
    private Integer score;
    @Column(nullable = false)
    private Integer userId;
    @Transient
    private List<AddressEntity> addresses;
    @Transient
    private transient List<OrderEntity> orders;

    @Override
    @PrePersist
    public void preCreate() {
        super.preCreate();
        this.realName = this.realName == null ? "" : this.realName;
        this.email = this.email == null ? "" : this.email;
    }

    @Override
    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
        this.realName = this.realName == null ? "" : this.realName;
        this.email = this.email == null ? "" : this.email;
    }

}
