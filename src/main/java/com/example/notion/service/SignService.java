package com.example.notion.service;

import com.example.notion.module.board.entity.Board;
import com.example.notion.module.sign.dto.SignResponse;
import com.example.notion.module.sign.entity.Sign;
import com.example.notion.module.sign.repository.SignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.notion.module.sign.mapper.SignMapper.SIGN_MAPPER;

@Service
@RequiredArgsConstructor
public class SignService {

    private final SignRepository signRepository;

    @Transactional
    public List<SignResponse> getSign() {
        return SIGN_MAPPER.toSignResponseList(signRepository.findAll());
    }

    @Transactional
    public void test(){
        Sign user = signRepository.findById(1L).orElse(null);

        List<Board> boardList = new ArrayList<>();
        for (int j=0;j<10;j++){
            boardList.add(new Board().create("title"+j,"cotent",user));
        }
//        user.setBoardList(boardList);

    }
}
