package shop.inventory.response;

import java.util.Date;

import lombok.Data;

@Data
public class UpdatedCategoryResponse {

	private Integer categoryId;
	private String categoryName;
	private String categoryCode;
	private Date categoryAddDate;
	private Integer categoryStatus;
	private String categoryDescription;

	public UpdatedCategoryResponse(Integer categoryId, String categoryName, String categoryCode, Date categoryAddDate,
			Integer categoryStatus, String categoryDescription) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryCode = categoryCode;
		this.categoryAddDate = categoryAddDate;
		this.categoryStatus = categoryStatus;
		this.categoryDescription = categoryDescription;
	}

	public UpdatedCategoryResponse() {
		// TODO Auto-generated constructor stub
	}
}
