package ee.camping.back_camping.domain.listing.feature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListingFeatureRepository extends JpaRepository<ListingFeature, Integer> {
    @Query("select l from ListingFeature l where l.listing.id = ?1")
    List<ListingFeature> findAllBy(Integer id);

}