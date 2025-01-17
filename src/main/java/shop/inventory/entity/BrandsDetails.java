package shop.inventory.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Brands")
@Data
//@SequenceGenerator(name = "brand_seq", sequenceName = "brand_id_seq", allocationSize = 1)
public class BrandsDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "brand_name", nullable = false, length = 255)
	private String brandName;

	@Column(name = "description", length = 500)
	private String description;

	@Column(name = "created_at", nullable = false)
	private String createdAt;

	@Column(name = "status", nullable = false)
	private Boolean status;
	private String brandCode;

//	@ElementCollection
//	@CollectionTable(name = "brand_profile_images", joinColumns = @JoinColumn(name = "brand_id"))
//	private List<UploadDocEntity> profileImage;

}
