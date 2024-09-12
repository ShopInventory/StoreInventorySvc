package shop.inventory.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Brands")
@Data
@SequenceGenerator(name = "brand_seq", sequenceName = "brand_id_seq", allocationSize = 1)
public class BrandsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
	private Integer brandId;
	private String BrandName;
	private String description;
	
}
