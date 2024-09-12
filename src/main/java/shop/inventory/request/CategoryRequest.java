package shop.inventory.request;

import java.util.Date;

import lombok.Data;

@Data
public class CategoryRequest {

	private Integer categoryId;
	private String categoryName;
	private String categoryCode;
	private Date categoryAddDate;
	private int categoryStatus;
	private String categoryDescription;

}
