package shop.inventory.entity;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "suppliers")
@Data
@SequenceGenerator(name = "suppliers_seq", sequenceName = "suppliers_id_seq", allocationSize = 1)
public class SupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Suppliers_seq")
	private Integer supplierId;

	private String name;
	private String contactInfo;
	private String address;
	private String email;
	private String phoneNumber;
	private String webSite;

	public static Optional<CategoryDetails> stream() {
		// TODO Auto-generated method stub
		return null;
	}

}
