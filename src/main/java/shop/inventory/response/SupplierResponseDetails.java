package shop.inventory.response;

import lombok.Data;

@Data
public class SupplierResponseDetails {

	private Integer supplierId;
	private String supplierName;
	private String contactInfo;
	private String address;
	private String email;
	private String phoneNumber;
	private String webSite;

	public SupplierResponseDetails(Integer supplierId, String supplierName, String contactInfo, String address,
			String email, String phoneNumber, String webSite) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.contactInfo = contactInfo;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.webSite = webSite;
	}
}
