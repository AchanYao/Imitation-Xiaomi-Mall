package com.achan.xiaomi_store.model.jpa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Achan
 */
@Entity
@Table(name = "role")
@TableName("role")
@Data
@Accessors(chain = true)
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 10)
    private String name;
    @Column(name = "name_zh", length = 10)
    private String nameZh;
}
