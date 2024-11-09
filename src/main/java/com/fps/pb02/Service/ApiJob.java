package com.fps.pb02.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 */
@Component
@Service
public class ApiJob {



	private final RestTemplate restTemplate = new RestTemplate();

	@Scheduled(cron = "0 */1 * * * *", zone = "Asia/Ho_Chi_Minh") // Chạy mỗi 2 phút
	public void runCallLive() {
		String url = "https://checkin-time.onrender.com/liveserver"; // Địa chỉ của API
		try {
			String response = restTemplate.getForObject(url, String.class);

			// Tạo ObjectMapper để phân tích JSON
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(response);
			// Trích xuất giá trị của trường "message"
			String message = rootNode.path("message").asText();
			System.out.println("Live server API: " + message);

		} catch (Exception e) {
			System.err.println("Error calling the live server API: " + e.getMessage());
		}
	}


}
