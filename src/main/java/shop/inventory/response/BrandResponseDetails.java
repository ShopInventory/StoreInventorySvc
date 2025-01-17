package shop.inventory.response;

import lombok.Data;

@Data
public class BrandResponseDetails {

	public BrandResponseDetails(Integer brandId, String brandName, String brandCode, String createdAt, Boolean status) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		// this.description = description;
		this.brandCode = brandCode;
		this.createdAt = createdAt;
		this.status = status;
	}

	private Integer brandId;
	private String brandName;
//	private String description;
	private String brandCode;
	private String createdAt;
	private Boolean status;

}
