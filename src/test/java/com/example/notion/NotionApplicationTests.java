package com.example.notion;

import com.example.notion.sign.entity.Sign;
import com.example.notion.sign.repository.SignRepository;
import javassist.tools.web.BadHttpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NotionApplicationTests {

    @Autowired
    private SignRepository userRepository;

    @Test
    @Transactional
    void contextLoads() throws Exception{

        userRepository.save(new Sign());
//        List<Sign> signs = new ArrayList<>();
//        signs.add(new Sign());
//        signs.add(new Sign());
//        signs.add(new Sign());
//        userRepository.saveAll(signs);
//        Sign sign = userRepository.findById(1L).orElse(null);
//        System.out.println(sign.getId());

//        throw new IllegalAccessException("test");
    }

}
