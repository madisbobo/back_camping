package ee.camping.back_camping.domain.review;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Resource
    ReviewRepository reviewRepository;

    public List<Review> findReviewsBy(Integer listingId) {
        return reviewRepository.findReviewsBy(listingId);
    }
    public ScoreInfo findReviewInfo(Integer listingId) {
        return reviewRepository.findReviewInfo(listingId);
    }
}
