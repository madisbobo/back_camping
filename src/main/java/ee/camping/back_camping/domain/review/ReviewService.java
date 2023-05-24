package ee.camping.back_camping.domain.review;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Resource
    private ReviewRepository reviewRepository;


    public List<Review> findListingReviewsBy(Integer id) {
        return reviewRepository.findListingReviewsBy(id);
    }
}
