package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ecommerceespritpi.Entities.ImageData;

import java.util.List;
import java.util.Optional;

public interface IImageDataRepository extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByName(String name);

    Optional<ImageData> findById(int id);

    List<ImageData> findByProductId(Long productId);
}
