package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.siteRepository;
import com.example.demo.entities.Site;

@RestController
public class siteRestController {
    @Autowired
    private siteRepository siterepository;
	
	@GetMapping("getsites")
	public List<Site> getSitess(){
		return siterepository.findAll();
	}
	
}
