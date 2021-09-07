package com.example.notion.common.data;

import com.example.notion.module.board.entity.Board;
import com.example.notion.module.board.repository.BoardRepository;
import com.example.notion.module.sign.entity.Sign;
import com.example.notion.module.sign.repository.SignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestDataCreater implements ApplicationRunner {

    @Autowired
    private SignRepository signRepository;
    @Autowired
    private BoardRepository boardRepository;

    private static List<Long> userIdList = new ArrayList<>();
    private static List<Long> adminIdList = new ArrayList<>();
    private static List<Long> boardIdList = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createSign();
//        updateUser();
        createBoard();
//        removeUser();
    }

    public void createSign(){
        for (int i=0;i<10;i++){
            Sign user = new Sign().create("user"+i,"1234",1+i, Sign.SignType.USER);

            List<Board> boards = new ArrayList<>();
            for (int j=0;j<10;j++){
                boards.add(new Board().create("title"+j,"cotent", user));
            }
//            user.setBoardList(boards);

            user = signRepository.save(user);
            userIdList.add(user.getId());

            Sign admin = new Sign().create("admin"+i,"1234",1+i, Sign.SignType.ADMIN);
            adminIdList.add(signRepository.save(admin).getId());
        }
    }

    private void createBoard(){
        for (Long signId : userIdList){
            for (int i=0;i<10;i++){
                Board board = new Board().create("title"+i,"cotent", signRepository.getById(signId));
                boardIdList.add(boardRepository.save(board).getId());
            }
        }
    }

    public void updateUser(){
        Sign user = signRepository.getById(userIdList.get(0));
        List<Board> boardList = new ArrayList<>();
        for (int j=0;j<10;j++){
            boardList.add(new Board().create("title"+j,"cotent",user));
        }
//        user.setBoardList(boardList);

        user.setUserName("tttt");
    }

    private void removeUser(){
        signRepository.deleteById(userIdList.get(0));
    }
}
