package com.example.notion.sign.repository;

import com.example.notion.sign.entity.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<Sign,Long>{

    Sign findByUserName(String userName);
}
