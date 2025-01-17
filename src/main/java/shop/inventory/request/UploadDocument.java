package shop.inventory.request;

import lombok.Data;

@Data
public class UploadDocument {

	private String src;

	private String name;

	private String size;

	private String type;
}
