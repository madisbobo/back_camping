package ee.camping.back_camping.domain.listing.feature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {

    @Resource
    private FeatureRepository featureRepository;

    public Feature getFeatureby(Integer featureId) {
        return featureRepository.findById(featureId).get();
    }
}
