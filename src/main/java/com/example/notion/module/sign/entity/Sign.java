package com.example.notion.module.sign.entity;

import com.example.notion.common.entity.BaseEntity;
import com.example.notion.module.board.entity.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
// @Table(name = "tb_sign",indexes = @Index(name = "i_sing",columnList = "userName")) // 인덱싱
@Table(name = "tb_sign")
@Getter
@NoArgsConstructor
@DynamicUpdate
@TableGenerator(
        name = "SIGN_SEQ_SEQUENCE",
        table = "TB_SEQUENCE",
        pkColumnValue = "SIGN_SEQ",
        allocationSize = 1
)
public class Sign extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SIGN_SEQ_SEQUENCE") // 테이블
    private Long id;

    @Column
    @Setter
    private String userName;

    private String password;

    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SignType signType;

    public enum SignType {

        USER("Super"),
        ADMIN("Normal");

        private final String value;
        SignType(String value) {
            this.value = value;
        }
        public String getKey() { return name(); }
        public String getValue() { return value; }
    }


    private Sign(String userName, String password, Integer age, SignType signType) {
        this.userName = userName;
        this.password = password;
        this.isDeleted = false;
        this.age = age;
        this.signType = signType;
    }

    public Sign create(String userName, String password, Integer age, SignType signType){
        return new Sign(userName,password,age,signType);
    }


}
