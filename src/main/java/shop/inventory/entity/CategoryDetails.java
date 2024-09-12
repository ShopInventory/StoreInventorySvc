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
@Table(name = "Categories")
@Data
@SequenceGenerator(name = "category_seq", sequenceName = "category_id_seq", allocationSize = 1)
public class CategoryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	private Integer categoryId;

	private String categoryName;
	private String categoryCode;
	private Date categoryAddDate;
	private Integer categoryStatus;
	private String categoryDescription;
}
