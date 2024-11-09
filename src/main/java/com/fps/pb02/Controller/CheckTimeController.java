package com.fps.pb02.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import payload.ApiResponse;



@RestController
public class CheckTimeController {
	@GetMapping("/liveserver")
	public ApiResponse  liveServer() {
		return new ApiResponse(true, "live", "");
	}

}