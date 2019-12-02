package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Picture;

public interface pictureRepository extends JpaRepository<Picture, Long>{

}
