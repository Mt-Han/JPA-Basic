package com.example.notion.module.board.dto;

import lombok.Data;

@Data
public class BoardResponse {

    private Long id;

    private String title;

    private String content;
}
