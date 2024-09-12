package shop.inventory.response;

import lombok.Data;

@Data
public class BrandRespDetails {

	public BrandRespDetails(Integer brandId, String brandName, String description) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.description = description;
	}
	private Integer brandId;
	private String brandName;
	private String description;
}
