package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.dto.FeatureDto;
import ee.camping.back_camping.domain.listing.feature.Feature;
import ee.camping.back_camping.domain.listing.feature.FeatureMapper;
import ee.camping.back_camping.domain.listing.feature.FeatureService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturesService {

    @Resource
    private FeatureService featureService;

    @Resource
    private FeatureMapper featureMapper;


    public List<FeatureDto> getAllFeatures() {
        List<Feature> allFeatures = featureService.getAllFeatures();
        return featureMapper.toFeatureDtos(allFeatures);
    }
}
