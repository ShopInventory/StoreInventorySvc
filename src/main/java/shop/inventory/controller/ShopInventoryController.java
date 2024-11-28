package shop.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.inventory.exception.ShopInventoryException;
import shop.inventory.request.BrandRequestDetails;
import shop.inventory.request.CategoryRequest;
import shop.inventory.request.SupplierRequest;
import shop.inventory.response.ApiResponse;
import shop.inventory.response.BrandRespDetails;
import shop.inventory.response.BrandResponseDetails;
import shop.inventory.response.CategoryResponse;
import shop.inventory.response.SelectCategoryResponse;
import shop.inventory.response.SupplierResponseDetail;
import shop.inventory.response.SupplierResponseDetails;
import shop.inventory.response.UpdatedCategoryResponse;
import shop.inventory.service.ShopInventoryService;

@RestController
@RequestMapping("/shopInventory")
public class ShopInventoryController {

	private final ShopInventoryService shopInventoryService;
	private static final Logger logger = LoggerFactory.getLogger(ShopInventoryController.class);

	@Autowired
	public ShopInventoryController(ShopInventoryService shopInventoryService) {
		this.shopInventoryService = shopInventoryService;
	}

//	@PostMapping("/saveCategoryDetails")
//	public ResponseEntity<ApiResponse<CategoryResponse>> saveCategoryDetails(
//			@RequestBody CategoryRequest categoryRequest) {
//		try {
//			CategoryResponse savedCategory = shopInventoryService.saveCategoryDetails(categoryRequest);
//			return ResponseEntity.status(HttpStatus.CREATED)
//					.body(ApiResponse.success("Data saved successfully", savedCategory));
//		} catch (ShopInventoryException e) {
//			logger.error("Error saving category: {}", categoryRequest, e);
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body(ApiResponse.error("Duplicate Data not Allowed..!!", "INTERNAL_SERVER_ERROR"));
//		} catch (Exception e) {
//			logger.error("Unexpected error occurred while saving category: {}", categoryRequest, e);
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body(ApiResponse.error("Unexpected error occurred", "INTERNAL_SERVER_ERROR"));
//		}
//	}

	@PostMapping("/updateCategoryDetails")
	public ResponseEntity<ApiResponse<UpdatedCategoryResponse>> updateCategoryDetails(
			@RequestBody CategoryRequest categoryRequest) {
		try {
			logger.info("Updating category: {}", categoryRequest);
			UpdatedCategoryResponse updatedCategory = shopInventoryService.updateCategoryDetails(categoryRequest);
			return ResponseEntity.status(HttpStatus.OK)
					.body(ApiResponse.success("Data updated successfully", updatedCategory));
		} catch (ShopInventoryException e) {
			logger.error("Error updating category: {}", categoryRequest, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Data already updated or not found..!!", "INTERNAL_SERVER_ERROR"));
		}
	}

	@PostMapping("/getCategoryDetails")
	public ResponseEntity<ApiResponse<?>> getCategoryDetails(@RequestBody CategoryRequest categoryRequest) {
		try {
			logger.info("Fetching category details for request: {}", categoryRequest);
			if (categoryRequest.getCategoryId() != null) {
				SelectCategoryResponse selectCategory = shopInventoryService
						.getCategoryDetails(categoryRequest.getCategoryId());
				return ResponseEntity.status(HttpStatus.OK)
						.body(ApiResponse.success("Data retrieved successfully", selectCategory));
			} else {
				List<SelectCategoryResponse> allCategories = shopInventoryService.getAllCategoryDetails();
				return ResponseEntity.status(HttpStatus.OK)
						.body(ApiResponse.success("All data retrieved successfully", allCategories));
			}
		} catch (ShopInventoryException e) {
			logger.error("Error retrieving category details: {}", categoryRequest, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("No Data Found..!!", "INTERNAL_SERVER_ERROR"));
		}
	}

	@PostMapping("/saveBrandDetails")
	public ResponseEntity<ApiResponse<BrandResponseDetails>> saveBrandDetails(
			@RequestBody BrandRequestDetails brandRequestDetails) {
		try {
	//		logger.info("Saving brand details: {}", brandRequestDetails);
			BrandResponseDetails brandResponseDetails = shopInventoryService.saveBrandDetails(brandRequestDetails);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(ApiResponse.success("Data saved successfully", brandResponseDetails));
		} catch (ShopInventoryException e) {
			logger.error("Error saving brand: {}", brandRequestDetails, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Duplicate Data not Allowed..!!", "INTERNAL_SERVER_ERROR"));
		} catch (Exception e) {
			logger.error("Unexpected error occurred while saving category: {}", brandRequestDetails, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Unexpected error occurred", "INTERNAL_SERVER_ERROR"));
		}
	}
	@PostMapping("/saveCategoryDetails")
	public ResponseEntity<ApiResponse<CategoryResponse>> saveCategoryDetails(
			@RequestBody CategoryRequest categoryRequest) {
		try {
			CategoryResponse savedCategory = shopInventoryService.saveCategoryDetails(categoryRequest);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(ApiResponse.success("Data saved successfully", savedCategory));
		} catch (ShopInventoryException e) {
			logger.error("Error saving category: {}", categoryRequest, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Duplicate Data not Allowed..!!", "INTERNAL_SERVER_ERROR"));
		} catch (Exception e) {
			logger.error("Unexpected error occurred while saving category: {}", categoryRequest, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Unexpected error occurred", "INTERNAL_SERVER_ERROR"));
		}
	}

	@PostMapping("/getBrandDetails")
	public ResponseEntity<ApiResponse<?>> getBrandDetails(@RequestBody BrandRequestDetails brandRequestDetails) {
		try {
			logger.info("Fetching brand details for request: {}", brandRequestDetails);
			if (brandRequestDetails.getBrandId() != null) {
				BrandRespDetails brandRespDetails = shopInventoryService
						.getBrandDetails(brandRequestDetails.getBrandId());
				return ResponseEntity.status(HttpStatus.OK)
						.body(ApiResponse.success("Data retrieved successfully", brandRespDetails));
			} else {
				List<BrandRespDetails> allBrandDetails = shopInventoryService.getAllBrandDetails();
				return ResponseEntity.status(HttpStatus.OK)
						.body(ApiResponse.success("All data retrieved successfully", allBrandDetails));
			}
		} catch (ShopInventoryException e) {
			logger.error("Error retrieving brand details: {}", brandRequestDetails, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("No Data Found..!!", "INTERNAL_SERVER_ERROR"));
		}
	}

	@PostMapping("/updateBrandDetails")
	public ResponseEntity<ApiResponse<BrandRespDetails>> updateBrandDetails(
			@RequestBody BrandRequestDetails brandRequestDetails) {
		try {
			logger.info("Updating brand: {}", brandRequestDetails);
			BrandRespDetails brandRespDetails = shopInventoryService.updateBrandDetails(brandRequestDetails);
			return ResponseEntity.status(HttpStatus.OK)
					.body(ApiResponse.success("Data updated successfully", brandRespDetails));
		} catch (ShopInventoryException e) {
			logger.error("Error updating brand: {}", brandRequestDetails, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Data already updated or not found..!!", "INTERNAL_SERVER_ERROR"));
		}
	}

	@PostMapping("/saveSuppliersDetails")
	public ResponseEntity<ApiResponse<SupplierResponseDetail>> saveSuppliersDetails(
			@RequestBody SupplierRequest supplierRequest) {
		try {
			SupplierResponseDetail supplierResponseDetail = shopInventoryService.saveSuppliersDetails(supplierRequest);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(ApiResponse.success("Data saved successfully", supplierResponseDetail));
		} catch (ShopInventoryException e) {
			logger.error("Error saving category: {}", supplierRequest, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Duplicate Data not Allowed..!!", "INTERNAL_SERVER_ERROR"));
		} catch (Exception e) {
			logger.error("Unexpected error occurred while saving category: {}", supplierRequest, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("Unexpected error occurred", "INTERNAL_SERVER_ERROR"));
		}
	}

	@PostMapping("/getSupplierDetails")
	public ResponseEntity<ApiResponse<?>> getSupplierDetails(@RequestBody SupplierRequest supplierRequest)
			throws ShopInventoryException {
		try {
			logger.info("Fetching Supplier details for request: {}", supplierRequest);
			if (supplierRequest.getSupplierId() != null) {
				SupplierResponseDetails supplierResponseDetails = shopInventoryService
						.getSupplierId(supplierRequest.getSupplierId());
				return ResponseEntity.status(HttpStatus.OK)
						.body(ApiResponse.success("Data retrieved successfully", supplierResponseDetails));
			} else {
				List<SupplierResponseDetails> allSupplierDetails = shopInventoryService.getAllSupplierDetails();
				return ResponseEntity.status(HttpStatus.OK)
						.body(ApiResponse.success("All data retrieved successfully", allSupplierDetails));
			}
		} catch (ShopInventoryException e) {
			logger.error("Error retrieving category details: {}", supplierRequest, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error("No Data Found..!!", "INTERNAL_SERVER_ERROR"));
		}
	}

	@PostMapping("/updateSupplierDetails")
	public ResponseEntity<ApiResponse<SupplierResponseDetails>> updateSupplierDetails(
			@RequestBody SupplierRequest supplierRequest) {
		try {
			logger.info("Updating Supplier Details: {}", supplierRequest);
			SupplierResponseDetails supplierResponseDetails = shopInventoryService
					.updateSupplierDetails(supplierRequest);
			return ResponseEntity.status(HttpStatus.OK)
					.body(ApiResponse.success("Data updated successfully", supplierResponseDetails));
		} catch (ShopInventoryException e) {
			logger.error("Error updating Supplier Details: {}", supplierRequest, e);
			String errorMessage = e.getMessage().contains("not found") ? "Supplier not found..!!"
					: "Data already updated or an error occurred..!!";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ApiResponse.error(errorMessage, "INTERNAL_SERVER_ERROR"));
		}
	}
}
