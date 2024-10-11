package com.fps.pb02.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CheckTimeController {



	@GetMapping("/liveserver")
	public String  liveServer() {
		return "live";
	}



}