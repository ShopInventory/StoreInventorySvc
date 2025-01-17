package shop.inventory.utility;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class UniqueCodeUtil {

	private UniqueCodeUtil() {
		// Private constructor to prevent instantiation
	}

	public static String generateUniqueCode(String uniqueCode) {
		if (uniqueCode == null || uniqueCode.isEmpty()) {
			throw new IllegalArgumentException("Unique Code cannot be null or empty");
		}

		// Process the brand name: take the first 3 characters, convert to uppercase,
		// and pad if necessary
		uniqueCode = uniqueCode.substring(0, Math.min(3, uniqueCode.length())).toUpperCase();
		uniqueCode = String.format("%-3s", uniqueCode).replace(' ', 'I');

		// Generate a unique ID based on the current timestamp in milliseconds
		long currentTimeMillis = System.currentTimeMillis();
		String uniqueId = String.valueOf(currentTimeMillis).substring(String.valueOf(currentTimeMillis).length() - 6);

		// Get the current month name
		LocalDateTime currentDateTime = LocalDateTime.now();
		String monthName = currentDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
		String firstTwoChars = monthName.substring(0, 2);
		String lastChar = monthName.substring(monthName.length() - 1);

		return String.format("%s-%s-%s-%s", uniqueCode, firstTwoChars, uniqueId, lastChar);
	}

}
