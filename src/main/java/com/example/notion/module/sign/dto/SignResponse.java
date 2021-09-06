package com.example.notion.module.sign.dto;

import com.example.notion.module.board.dto.BoardResponse;
import com.example.notion.module.sign.entity.Sign;
import lombok.Data;

import java.util.List;

@Data
public class SignResponse {
    private Long id;
    private String userName;
    private String password;
    private Integer age;
    private Sign.SignType signType;
    private List<BoardResponse> boardList;
}
