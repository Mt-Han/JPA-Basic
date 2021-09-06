package com.example.notion.controller;

import com.example.notion.module.sign.entity.Sign;
import com.example.notion.module.sign.repository.SignRepository;
import com.example.notion.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SignController {

    private final SignService signService;

    @GetMapping("/test")
    public ResponseEntity<?> test(){

        return ResponseEntity.ok(signService.getSign());
    }
}
