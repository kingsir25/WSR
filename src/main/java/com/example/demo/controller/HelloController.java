package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id: " + myId;
        //return girlProperties.getCupSize();
    }
    
    @GetMapping(value = "/write")
    public String write(@RequestParam(value = "size", required = false, defaultValue = "A") String mySize) {
    	if (mySize.compareTo("C") >1)  	
    	{
    		return "太大了吧";
    	} else
    	{
        return "size is " + mySize;
        //return girlProperties.getCupSize();
    	}
    }
    
}
