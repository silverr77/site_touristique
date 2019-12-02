package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.comment;

public interface commentRepository extends JpaRepository<comment, Long>{

}
