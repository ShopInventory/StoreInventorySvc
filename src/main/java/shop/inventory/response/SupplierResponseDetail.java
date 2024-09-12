package shop.inventory.response;

import lombok.Data;

@Data
public class SupplierResponseDetail {
	private Integer supplierId;
	private String supplierName;

	public SupplierResponseDetail(Integer supplierId, String supplierName) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;

	}

	public SupplierResponseDetail() {
		// TODO Auto-generated constructor stub
	}
}
