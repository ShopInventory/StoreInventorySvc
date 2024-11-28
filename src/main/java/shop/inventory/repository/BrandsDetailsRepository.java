package shop.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.inventory.entity.BrandsDetails;

@Repository
public interface BrandsDetailsRepository extends JpaRepository<BrandsDetails, Integer> {

	Optional<BrandsDetails> findByBrandId(Integer brandId);

//	BrandsDetails save(BrandsDetails brandsDetails);
}
