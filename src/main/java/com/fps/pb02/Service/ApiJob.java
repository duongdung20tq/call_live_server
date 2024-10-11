package com.fps.pb02.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Component
@Service
public class ApiJob {



	private final RestTemplate restTemplate = new RestTemplate();

	@Scheduled(cron = "0 */2 * * * *", zone = "Asia/Ho_Chi_Minh") // Chạy mỗi 2 phút
	public void runCallLive() {
		String url = "https://checkin-time.onrender.com/liveserver"; // Địa chỉ của API
		try {
			String response = restTemplate.getForObject(url, String.class);
			System.out.println("API response: " + response);
		} catch (Exception e) {
			System.err.println("Error calling the live server API: " + e.getMessage());
		}
	}


}
