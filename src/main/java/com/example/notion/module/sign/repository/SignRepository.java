package com.example.notion.module.sign.repository;

import com.example.notion.module.sign.entity.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<Sign,Long>{

}
