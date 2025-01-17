package shop.inventory.response;

import java.util.List;

import lombok.Data;
import shop.inventory.request.UploadDocument;

@Data
public class BrandRespDetails {

//	public BrandRespDetails(Integer brandId, String brandName, String description, String brandCode, String createdAt,
//			Boolean status) {
//		super();
//		this.brandId = brandId;
//		this.brandName = brandName;
//		this.description = description;
//		this.brandCode = brandCode;
//		this.createdAt = createdAt;
//		this.status = status;
//	}
//
//	private Integer brandId;
//	private String brandName;
//	private String description;
//	private String brandCode;
//	private String createdAt;	
//	private Boolean status;

	private Integer brandId;
	private String brandName;
	private String description;
	private String brandCode;
	private String createdAt;
	private Boolean status;
	private List<UploadDocument> profileImage;
}
