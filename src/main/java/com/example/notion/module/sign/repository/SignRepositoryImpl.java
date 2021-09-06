package com.example.notion.module.sign.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SignRepositoryImpl implements SignRepositoryCustom {

    private final JPAQueryFactory queryFactory;

}
