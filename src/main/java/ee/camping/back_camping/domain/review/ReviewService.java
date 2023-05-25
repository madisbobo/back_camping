package ee.camping.back_camping.domain.review;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Resource
    private ReviewRepository reviewRepository;

    public ScoreInfo findScoreInfo(Integer listingId) {
        return reviewRepository.findScoreInfo(listingId);
    }
}
