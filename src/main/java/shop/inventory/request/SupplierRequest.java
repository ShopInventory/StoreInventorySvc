package shop.inventory.request;

import lombok.Data;

@Data
public class SupplierRequest {

	private Integer supplierId;
	private String name;
	private String contactInfo;
	private String address;
	private String email;
	private String phoneNumber;
	private String webSite;
}
