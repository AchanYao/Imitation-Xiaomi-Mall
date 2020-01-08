package com.achan.xiaomi_store.model.jpa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Achan
 */
@Entity
@Table(name = "user_role")
@Data
@Accessors(chain = true)
@TableName("user_role")
public class UserAndRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer roleId;
}
