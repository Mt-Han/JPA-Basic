package com.example.notion.module.sign.entity;

import com.example.notion.common.entity.BaseEntity;
import com.example.notion.module.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
// @Table(name = "tb_sign",indexes = @Index(name = "i_sing",columnList = "userName")) // 인덱싱
@Table(name = "tb_sign")
@Getter
@NoArgsConstructor
public class Sign extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
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

    @OneToMany(mappedBy = "sign")
    private List<Board> boardList;

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
