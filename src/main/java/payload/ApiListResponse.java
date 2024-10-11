package payload;

import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ApiListResponse {
    private Boolean success;
    private ResponseEntity<String> message;

    public ApiListResponse(Boolean success, ResponseEntity<String> message) {
        this.success = success;
        this.message = message;
    }

}
