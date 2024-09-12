package shop.inventory.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShopInventoryException extends Exception {
	private String errorCode;

	public ShopInventoryException(String message) {
		super(message);
	}

	public ShopInventoryException(String message, Throwable cause) {
		super(message, cause);
		this.errorCode = null;
	}

	public Error getErrorCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
