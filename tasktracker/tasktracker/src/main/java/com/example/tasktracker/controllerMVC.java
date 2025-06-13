package com.example.tasktracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerMVC {
	
	@GetMapping("/check")
	public String MVC()
	{
		return "Okk";
	}
}
