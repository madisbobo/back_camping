package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.domain.listing.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ListingFeatureRepository extends JpaRepository<ListingFeature, Integer> {
    @Query("select l from ListingFeature l where l.listing.id = ?1")
    List<ListingFeature> findAllBy(Integer id);

    @Transactional
    @Modifying
    @Query("delete from ListingFeature l where l.listing = ?1")
    void deleteAllBy(Listing listing);

}