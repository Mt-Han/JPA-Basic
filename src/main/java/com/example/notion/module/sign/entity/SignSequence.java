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
@SequenceGenerator(
        name = "SIGN_SEQ_SEQUENCE",
        sequenceName = "SIGN_SEQ",  // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1,
        allocationSize = 40
)
public class SignSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIGN_SEQ_SEQUENCE") // 시퀀스
    private Long id;

    @CreationTimestamp
    private LocalDateTime createDt;

    @Column
    private String userName;

    private String password;

    private Boolean isDeleted;

    private Integer age;

}
