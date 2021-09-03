package com.example.notion.controller;

import com.example.notion.sign.entity.Sign;
import com.example.notion.sign.repository.SignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SignController {

    @Autowired
    private SignRepository signRepository;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        List<Sign> signList = new ArrayList<>();
        signList.add(new Sign());
        signList.add(new Sign());
        signList.add(new Sign());
//        Sign sign = signRepository.save(new Sign());
        signRepository.saveAll(signList);
        return ResponseEntity.ok(null);
    }
}
