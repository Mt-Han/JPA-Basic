package com.example.notion.module.board.entity;

import com.example.notion.common.entity.BaseEntity;
import com.example.notion.module.sign.entity.Sign;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_board")
@TableGenerator(
        name = "BOARD_SEQ_SEQUENCE",
        table = "TB_SEQUENCE",
        pkColumnValue = "BOARD_SEQ",
        allocationSize = 1
)
@NoArgsConstructor
@Getter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_SEQUENCE")
    private Long id;

    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sign_id")
    private Sign sign;

    private Board(String title, String content, Sign sign) {
        this.title = title;
        this.content = content;
        this.isDeleted = false;
        this.sign = sign;
    }

    public Board create(String title, String content, Sign sign) {
        return new Board(title, content, sign);
    }
}
