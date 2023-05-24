package ee.camping.back_camping.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("select r from Review r where r.listing.ownerUser.id = ?1")
    List<Review> findListingReviewsBy(Integer id);

}