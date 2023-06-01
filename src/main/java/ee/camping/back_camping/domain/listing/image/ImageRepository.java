package ee.camping.back_camping.domain.listing.image;

import ee.camping.back_camping.domain.listing.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Image i where i.listing = ?1")
    void deleteAllBy(Listing listing);

    @Query("select i from Image i where i.listing.id = ?1 order by i.id limit  1")
    Image findImageBy(Integer listingId);

    @Query("select i from Image i where i.listing.id = ?1")
    List<Image> findImagesBy(Integer listingId);



}