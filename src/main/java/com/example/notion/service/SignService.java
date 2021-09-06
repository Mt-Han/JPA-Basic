package com.example.notion.service;

import com.example.notion.module.sign.dto.SignResponse;
import com.example.notion.module.sign.repository.SignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
