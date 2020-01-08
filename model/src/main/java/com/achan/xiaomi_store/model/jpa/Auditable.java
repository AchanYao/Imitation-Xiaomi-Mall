package com.achan.xiaomi_store.model.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
public abstract class Auditable {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected long createTime;
    @LastModifiedDate
    @Column(nullable = false)
    protected long modifyTime;

    @PrePersist
    public void preCreate() {
        createTime = System.currentTimeMillis();
        modifyTime = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        modifyTime = System.currentTimeMillis();
    }

}
