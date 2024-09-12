package shop.inventory.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class CategoryDetailsDTO {

	private String operationType; // "save", "update", "delete"
	private Integer categoryId; // Required for update and delete
	private String categoryName;
	private String categoryCode;
	private Date categoryAddDate;
	private Integer categoryStatus;
	private String categoryDescription;
}
