package shop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.inventory.entity.SupplierDetails;

@Repository
public interface SupplierDetailsRepository extends JpaRepository<SupplierDetails, Integer> {

	SupplierDetails save(SupplierDetails supplierDetails);

}
