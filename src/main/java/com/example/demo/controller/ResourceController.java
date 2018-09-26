package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.ResourceRepository;
import com.example.demo.domain.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ResourceController {
	
	@Autowired
	private ResourceRepository resourceRepository;
    
	@GetMapping(value = "/Resources")
	public List<Resource> resourceList(){
		return resourceRepository.findAll();
	}
}
