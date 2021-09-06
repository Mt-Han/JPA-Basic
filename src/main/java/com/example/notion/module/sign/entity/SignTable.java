package com.example.notion.module.sign.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "tb_sign")
@Getter
@NoArgsConstructor
@TableGenerator(
        name = "SIGN_SEQ_SEQUENCE",
        table = "TB_SEQUENCE",
        pkColumnValue = "SIGN_SEQ",
        allocationSize = 1
)
public class SignTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SIGN_SEQ_SEQUENCE") // 테이블
    private Long id;

    @CreationTimestamp
    private LocalDateTime createDt;

    @Column
    private String userName;

    private String password;

    private Boolean isDeleted;

    private Integer age;
}
