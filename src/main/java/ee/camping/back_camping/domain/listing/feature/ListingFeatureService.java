package ee.camping.back_camping.domain.listing.feature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListingFeatureService {

    @Resource
    private ListingFeatureRepository listingFeatureRepository;


    public List<ListingFeature> findListingFeaturesBy(Integer listingId) {
        return listingFeatureRepository.findAllBy(listingId);
    }
}
