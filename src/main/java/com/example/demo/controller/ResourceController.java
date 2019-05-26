package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.ResourceRepository;
import com.example.demo.domain.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    /**通过参数 添加一个resource*/  
    @PostMapping(value="/Resources/add")  
    public Resource paramAdd(@RequestParam("name") String name,
    		                 @RequestParam("sex") String sex,
    		                 @RequestParam("level") String level,
    		                 @RequestParam("comedate") Integer comedate){  
    	
    	Resource resone=new Resource();  
    	resone.setName(name);
    	resone.setSex(sex);
    	resone.setComeDate(comedate);
    	resone.setLevel(level);
        return resourceRepository.save(resone);  
    }
}
