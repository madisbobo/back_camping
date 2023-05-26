package ee.camping.back_camping.domain.listing.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query("select i from Image i where i.listing.id = ?1 ")
    List<Image> findListingImagesBy(Integer id);

    @Query("select i from Image i where i.listing.id = ?1 order by i.id limit  1")
    Image findImageBy(Integer listingId);

    @Query("select i from Image i where i.id = ?1")
    List<Image> findImagesBy(Integer id);



}