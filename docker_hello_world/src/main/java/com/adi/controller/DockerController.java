package com.adi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
	@GetMapping(value="/hello")
	public String getDocker() {
		return "Hello Docker!!!";
	}

}
