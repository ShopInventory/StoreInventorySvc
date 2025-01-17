package shop.inventory.request;

import java.util.List;

import lombok.Data;

@Data
public class BrandRequestDetails {

	private Integer brandId;
	private String brandName;
	private String description;
	private String createdAt;
	private Boolean status;
//	private List<UploadDocument> profileImage;
}
