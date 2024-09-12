package shop.inventory.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "status", "data", "message", "error" })
public class ApiResponse<T> {
	private boolean Status;
	private T data;
	private String message;
	private String error;

	public static <T> ApiResponse<T> success(String message, T data) {
		return new ApiResponse<>(true, data, message, null);
	}

	public static <T> ApiResponse<T> error(String message, String error) {
		return new ApiResponse<>(false, null, message, error);
	}

	public static <T> ApiResponse<T> error(String message) {
		return new ApiResponse<>(false, null, message, null);
	}

}
