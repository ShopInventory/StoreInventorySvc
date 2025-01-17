package shop.inventory.entity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UploadDocEntity {
	@Column(name = "src")
	private String src;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "size", nullable = false)
	private String size;

	@Column(name = "type", nullable = false)
	private String type;
}
