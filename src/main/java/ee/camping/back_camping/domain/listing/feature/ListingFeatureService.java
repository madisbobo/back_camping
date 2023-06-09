package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.domain.listing.Listing;
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

    public void saveListingFeatures(List<ListingFeature> listingFeatures) {
        listingFeatureRepository.saveAll(listingFeatures);
    }

    public void deleteAllBy(Listing listing) {
        listingFeatureRepository.deleteAllBy(listing);
    }
}
