package shop.inventory.response;

import lombok.Data;

@Data
public class CategoryResponse {

	private Integer categoryId;
	private String categoryName;

	public CategoryResponse(Integer categoryId, String categoryName

	) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public CategoryResponse() {
		// TODO Auto-generated constructor stub
	}
}
