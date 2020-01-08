package com.achan.xiaomi_store.model.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Accessors(chain = true)
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(nullable = false, length = 50)
    protected String username;
    @Column(nullable = false, length = 100)
    @JsonIgnore
    protected String password;
    private Integer enable = 1;
    private Integer locked = 0;
    @Transient
    private transient List<RoleEntity> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !(locked == 1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable == 1;
    }

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected long createTime;
    @LastModifiedDate
    @Column(nullable = false)
    protected long modifyTime;

    @PrePersist
    public void preCreate() {
        createTime = new Date().getTime();
        modifyTime = new Date().getTime();
    }

    @PreUpdate
    public void preUpdate() {
        modifyTime = new Date().getTime();
    }
}
