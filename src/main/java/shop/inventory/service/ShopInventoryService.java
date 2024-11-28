package shop.inventory.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.inventory.entity.BrandsDetails;
import shop.inventory.entity.CategoryDetails;
import shop.inventory.entity.SupplierDetails;
import shop.inventory.exception.ShopInventoryException;
import shop.inventory.repository.BrandsDetailsRepository;
import shop.inventory.repository.ShopInventoryRepository;
import shop.inventory.repository.SupplierDetailsRepository;
import shop.inventory.request.BrandRequestDetails;
import shop.inventory.request.CategoryRequest;
import shop.inventory.request.SupplierRequest;
import shop.inventory.response.BrandRespDetails;
import shop.inventory.response.BrandResponseDetails;
import shop.inventory.response.CategoryResponse;
import shop.inventory.response.SelectCategoryResponse;
import shop.inventory.response.SupplierResponseDetail;
import shop.inventory.response.SupplierResponseDetails;
import shop.inventory.response.UpdatedCategoryResponse;

@Service
public class ShopInventoryService {

	private final ShopInventoryRepository inventoryRepository;
	private final BrandsDetailsRepository brandsDetailsRepository;
	private final SupplierDetailsRepository supplierDetailsRepository;
	private static final Logger logger = LoggerFactory.getLogger(ShopInventoryService.class);

	@Autowired
	public ShopInventoryService(ShopInventoryRepository inventoryRepository,
			BrandsDetailsRepository brandsDetailsRepository, SupplierDetailsRepository supplierDetailsRepository) {
		this.inventoryRepository = inventoryRepository;
		this.brandsDetailsRepository = brandsDetailsRepository;
		this.supplierDetailsRepository = supplierDetailsRepository;
	}

//	public CategoryResponse saveCategoryDetails(CategoryRequest categoryRequest) throws ShopInventoryException {
//		try {
//			logger.info("Saving category: {}", categoryRequest);
//			CategoryDetails category = new CategoryDetails();
//			category.setCategoryName(categoryRequest.getCategoryName());
//			category.setCategoryCode(categoryRequest.getCategoryCode());
//			category.setCategoryAddDate(categoryRequest.getCategoryAddDate());
//			category.setCategoryStatus(categoryRequest.getCategoryStatus());
//			category.setCategoryDescription(categoryRequest.getCategoryDescription());
//			category = inventoryRepository.save(category);
//			return new CategoryResponse(category.getCategoryId(), category.getCategoryName());
//		} catch (Exception e) {
//			logger.error("Error saving category", e);
//			throw new ShopInventoryException("Error saving category", e);
//		}
//	}

	public UpdatedCategoryResponse updateCategoryDetails(CategoryRequest categoryRequest)
			throws ShopInventoryException {
		try {
			logger.info("Updating category: {}", categoryRequest);
			Optional<CategoryDetails> optionalCategory = inventoryRepository.findById(categoryRequest.getCategoryId());
			if (optionalCategory.isEmpty()) {
				throw new ShopInventoryException("Category not found for ID: " + categoryRequest.getCategoryId());
			}
			CategoryDetails categoryDetails = optionalCategory.get();
			categoryDetails.setCategoryName(categoryRequest.getCategoryName());
			categoryDetails.setCategoryCode(categoryRequest.getCategoryCode());
			categoryDetails.setCategoryAddDate(categoryRequest.getCategoryAddDate());
			categoryDetails.setCategoryStatus(categoryRequest.getCategoryStatus());
			categoryDetails.setCategoryDescription(categoryRequest.getCategoryDescription());
			inventoryRepository.save(categoryDetails);
			return new UpdatedCategoryResponse(categoryDetails.getCategoryId(), categoryDetails.getCategoryName(),
					categoryDetails.getCategoryCode(), categoryDetails.getCategoryAddDate(),
					categoryDetails.getCategoryStatus(), categoryDetails.getCategoryDescription());
		} catch (Exception e) {
			logger.error("Error updating category", e);
			throw new ShopInventoryException("Error updating category", e);
		}
	}

	public SelectCategoryResponse getCategoryDetails(Integer categoryId) throws ShopInventoryException {
		try {
			logger.info("Retrieving category with ID: {}", categoryId);
			Optional<CategoryDetails> categoryDetailsOpt = inventoryRepository.findById(categoryId);
			if (categoryDetailsOpt.isPresent()) {
				CategoryDetails categoryDetails = categoryDetailsOpt.get();
				return new SelectCategoryResponse(categoryDetails.getCategoryId(), categoryDetails.getCategoryName(),
						categoryDetails.getCategoryCode(), categoryDetails.getCategoryAddDate(),
						categoryDetails.getCategoryStatus(), categoryDetails.getCategoryDescription());
			} else {
				throw new ShopInventoryException("Category not found for ID: " + categoryId);
			}
		} catch (Exception e) {
			logger.error("Error retrieving category", e);
			throw new ShopInventoryException("Error retrieving category", e);
		}
	}

	public List<SelectCategoryResponse> getAllCategoryDetails() throws ShopInventoryException {
		try {
			logger.info("Retrieving all categories");
			List<CategoryDetails> categoryDetailsList = inventoryRepository.findAll();
			return categoryDetailsList.stream()
					.map(categoryDetails -> new SelectCategoryResponse(categoryDetails.getCategoryId(),
							categoryDetails.getCategoryName(), categoryDetails.getCategoryCode(),
							categoryDetails.getCategoryAddDate(), categoryDetails.getCategoryStatus(),
							categoryDetails.getCategoryDescription()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Error retrieving all categories", e);
			throw new ShopInventoryException("Error retrieving all categories", e);
		}
	}

	public BrandResponseDetails saveBrandDetails(BrandRequestDetails brandRequestDetails)
			throws ShopInventoryException {
		try {
			logger.info("Saving brand: {}", brandRequestDetails);
			BrandsDetails brandsDetails = new BrandsDetails();
			brandsDetails.setBrandName(brandRequestDetails.getBrandName());
			brandsDetails.setDescription(brandRequestDetails.getDescription());
			brandsDetails = brandsDetailsRepository.save(brandsDetails);
			return new BrandResponseDetails(brandsDetails.getBrandId(), brandsDetails.getBrandName());
		} catch (Exception e) {
			logger.error("Error saving brand", e);
			throw new ShopInventoryException("Error saving brand", e);
		}
	}

	public CategoryResponse saveCategoryDetails(CategoryRequest categoryRequest) throws ShopInventoryException {
		try {
			logger.info("Saving category: {}", categoryRequest);
			CategoryDetails category = new CategoryDetails();
			category.setCategoryName(categoryRequest.getCategoryName());
			category.setCategoryCode(categoryRequest.getCategoryCode());
			category.setCategoryAddDate(categoryRequest.getCategoryAddDate());
			category.setCategoryStatus(categoryRequest.getCategoryStatus());
			category.setCategoryDescription(categoryRequest.getCategoryDescription());
			category = inventoryRepository.save(category);
			return new CategoryResponse(category.getCategoryId(), category.getCategoryName());
		} catch (Exception e) {
			logger.error("Error saving category", e);
			throw new ShopInventoryException("Error saving category", e);
		}
	}

	public BrandRespDetails getBrandDetails(Integer brandId) throws ShopInventoryException {
		try {
			logger.info("Retrieving brand with ID: {}", brandId);
			Optional<BrandsDetails> brandDetailsOpt = brandsDetailsRepository.findById(brandId);
			if (brandDetailsOpt.isPresent()) {
				BrandsDetails brandsDetails = brandDetailsOpt.get();
				return new BrandRespDetails(brandsDetails.getBrandId(), brandsDetails.getBrandName(),
						brandsDetails.getDescription());
			} else {
				throw new ShopInventoryException("Brand not found for ID: " + brandId);
			}
		} catch (Exception e) {
			logger.error("Error retrieving brand", e);
			throw new ShopInventoryException("Error retrieving brand", e);
		}
	}

	public List<BrandRespDetails> getAllBrandDetails() throws ShopInventoryException {
		try {
			logger.info("Retrieving all brands");
			List<BrandsDetails> brandsDetailsList = brandsDetailsRepository.findAll();
			return brandsDetailsList.stream().map(brandDetails -> new BrandRespDetails(brandDetails.getBrandId(),
					brandDetails.getBrandName(), brandDetails.getDescription())).collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Error retrieving all brands", e);
			throw new ShopInventoryException("Error retrieving all brands", e);
		}
	}

	public BrandRespDetails updateBrandDetails(BrandRequestDetails brandRequestDetails) throws ShopInventoryException {
		try {
			logger.info("Updating brand: {}", brandRequestDetails);
			Optional<BrandsDetails> optionalBrand = brandsDetailsRepository.findById(brandRequestDetails.getBrandId());
			if (optionalBrand.isEmpty()) {
				throw new ShopInventoryException("Brand not found for ID: " + brandRequestDetails.getBrandId());
			}
			BrandsDetails brandsDetails = optionalBrand.get();
			brandsDetails.setBrandName(brandRequestDetails.getBrandName());
			brandsDetails.setDescription(brandRequestDetails.getDescription());
			brandsDetailsRepository.save(brandsDetails);
			return new BrandRespDetails(brandsDetails.getBrandId(), brandsDetails.getBrandName(),
					brandsDetails.getDescription());
		} catch (Exception e) {
			logger.error("Error updating brand", e);
			throw new ShopInventoryException("Error updating brand", e);
		}
	}

	public SupplierResponseDetail saveSuppliersDetails(SupplierRequest supplierRequest) throws ShopInventoryException {
		try {
			logger.info("Saving category: {}", supplierRequest);
			SupplierDetails supplierDetails = new SupplierDetails();
			supplierDetails.setName(supplierRequest.getName());
			supplierDetails.setAddress(supplierRequest.getAddress());
			supplierDetails.setContactInfo(supplierRequest.getContactInfo());
			supplierDetails.setEmail(supplierRequest.getEmail());
			supplierDetails.setPhoneNumber(supplierRequest.getPhoneNumber());
			supplierDetails.setWebSite(supplierRequest.getWebSite());
			supplierDetails = supplierDetailsRepository.save(supplierDetails);
			return new SupplierResponseDetail(supplierDetails.getSupplierId(), supplierDetails.getName());
		} catch (Exception e) {
			logger.error("Error saving Supplier Details", e);
			throw new ShopInventoryException("Error saving Supplier Details", e);
		}
	}

	public SupplierResponseDetails getSupplierId(Integer supplierId) throws ShopInventoryException {
		try {
			logger.info("Retrieving category with ID: {}", supplierId);
			Optional<SupplierDetails> supplierDetailsOpt = supplierDetailsRepository.findById(supplierId);
			if (supplierDetailsOpt.isPresent()) {
				SupplierDetails supplierDetails = supplierDetailsOpt.get();
				return new SupplierResponseDetails(supplierDetails.getSupplierId(), supplierDetails.getName(),
						supplierDetails.getContactInfo(), supplierDetails.getAddress(), supplierDetails.getEmail(),
						supplierDetails.getPhoneNumber(), supplierDetails.getWebSite());
			} else {
				throw new ShopInventoryException("Category not found for ID: " + supplierId);
			}
		} catch (Exception e) {
			logger.error("Error retrieving category", e);
			throw new ShopInventoryException("Error retrieving category", e);
		}
	}

	public List<SupplierResponseDetails> getAllSupplierDetails() throws ShopInventoryException {
		try {
			logger.info("Retrieving all suppliers");
			List<SupplierDetails> supplierDetails = supplierDetailsRepository.findAll();

			return supplierDetails.stream() // Correct the stream from the list
					.map(supplierDetail -> new SupplierResponseDetails(supplierDetail.getSupplierId(),
							supplierDetail.getName(), supplierDetail.getContactInfo(), supplierDetail.getAddress(),
							supplierDetail.getEmail(), supplierDetail.getPhoneNumber(), supplierDetail.getWebSite()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Error retrieving all suppliers", e);
			throw new ShopInventoryException("Error retrieving all suppliers", e);
		}

	}

	public SupplierResponseDetails updateSupplierDetails(SupplierRequest supplierRequest)
			throws ShopInventoryException {
		try {
			logger.info("Updating supplier: {}", supplierRequest);
			Optional<SupplierDetails> supplierDetails = supplierDetailsRepository
					.findById(supplierRequest.getSupplierId());

			if (supplierDetails.isEmpty()) {
				throw new ShopInventoryException("Supplier not found for ID: " + supplierRequest.getSupplierId());
			}

			SupplierDetails supplierDetailsToUpdate = supplierDetails.get();
			supplierDetailsToUpdate.setName(supplierRequest.getName());
			supplierDetailsToUpdate.setContactInfo(supplierRequest.getContactInfo());
			supplierDetailsToUpdate.setAddress(supplierRequest.getAddress());
			supplierDetailsToUpdate.setEmail(supplierRequest.getEmail());
			supplierDetailsToUpdate.setPhoneNumber(supplierRequest.getPhoneNumber());
			supplierDetailsToUpdate.setWebSite(supplierRequest.getWebSite());

			supplierDetailsRepository.save(supplierDetailsToUpdate); // Correct method is 'save()' to persist updates

			return new SupplierResponseDetails(supplierDetailsToUpdate.getSupplierId(),
					supplierDetailsToUpdate.getName(), supplierDetailsToUpdate.getContactInfo(),
					supplierDetailsToUpdate.getAddress(), supplierDetailsToUpdate.getEmail(),
					supplierDetailsToUpdate.getPhoneNumber(), supplierDetailsToUpdate.getWebSite());

		} catch (Exception e) {
			logger.error("Error updating supplier", e); // Updated logging to reference suppliers
			throw new ShopInventoryException("Error updating supplier", e); // Consistent exception message
		}
	}
}