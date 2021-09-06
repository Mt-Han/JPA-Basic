package com.example.notion.common.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Column(nullable = false)
    protected Boolean isDeleted;

    @CreationTimestamp
    protected LocalDateTime createDt;

    @UpdateTimestamp
    protected LocalDateTime updateDt;

    public BaseEntity() {
        this.isDeleted = false;
    }

    public void remove() {
        this.isDeleted = true;
    }

    public void restore() {
        this.isDeleted = false;
    }
}
