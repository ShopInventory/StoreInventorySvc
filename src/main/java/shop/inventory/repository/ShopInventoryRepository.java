package shop.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.inventory.entity.BrandsDetails;
import shop.inventory.entity.CategoryDetails;

@Repository
public interface ShopInventoryRepository extends JpaRepository<CategoryDetails, Integer> {

	Optional<CategoryDetails> findById(Integer categoryId);

}
