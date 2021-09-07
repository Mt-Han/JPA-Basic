package com.example.notion;

import com.example.notion.module.board.entity.Board;
import com.example.notion.module.sign.entity.Sign;
import com.example.notion.module.sign.repository.SignRepository;
import com.example.notion.service.SignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NotionApplicationTests {

    @Autowired
    private SignRepository signRepository;

    @Autowired
    private SignService signService;


    @Test
    @Transactional
    void contextLoads() throws Exception{

        signService.test();

//        user.setUserName("tttt");
    }

}
