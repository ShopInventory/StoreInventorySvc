package shop.inventory.response;

import lombok.Data;

@Data
public class BrandResponseDetails {

	public BrandResponseDetails(Integer brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	//	this.description = description;
	}
	private Integer brandId;
	private String brandName;
	//private String description;
	
}
