package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.dto.FeatureDto;
import ee.camping.back_camping.domain.listing.feature.Feature;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeatureController {

    @Resource
    private FeaturesService featuresService;

    @GetMapping("/add-listing-features")
    @Operation(summary = "Tagastab kõik omadused/feature-d (ID, nimi)")
    public List<FeatureDto> getAllFeatures() {
        return featuresService.getAllFeatures();

    }

}
