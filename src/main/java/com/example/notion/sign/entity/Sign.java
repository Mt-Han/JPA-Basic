package com.example.notion.sign.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
// @Table(name = "tb_sign",indexes = @Index(name = "i_sing",columnList = "userName")) // 인덱싱
@Table(name = "tb_sign")
@Getter
@NoArgsConstructor
// 시퀀스
//@SequenceGenerator(
//        name = "SIGN_SEQ_SEQUENCE",
//        sequenceName = "SIGN_SEQ",  // 매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1,
//        allocationSize = 40
//)
// 테이블
//@TableGenerator(
//        name = "SIGN_SEQ_SEQUENCE",
//        table = "TB_SEQUENCE",
//        pkColumnValue = "SIGN_SEQ",
//        allocationSize = 1
//)
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 아이덴티티
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SIGN_SEQ_SEQUENCE") // 시퀀스
//    @GeneratedValue(strategy = GenerationType.TABLE,generator = "SIGN_SEQ_SEQUENCE") // 테이블
    private Long id;

    @CreationTimestamp
    private LocalDateTime createDt;

    @Column
    private String userName;

    private String password;

    private Boolean isDeleted;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private SignType signType;

    public enum SignType{

        USER("Super"),
        ADMIN("Normal");

        private final String value;

        SignType(String value) {
            this.value = value;
        }

        public String getKey() { return name(); }
        public String getValue() {
            return value;
        }

    }
}
