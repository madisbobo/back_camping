package ee.camping.back_camping.domain.listing.feature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    @Resource
    private FeatureRepository featureRepository;

    @Resource
    private FeatureMapper featureMapper;

    public Feature getFeatureby(Integer featureId) {
        return featureRepository.findById(featureId).get();
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();

    }
}
