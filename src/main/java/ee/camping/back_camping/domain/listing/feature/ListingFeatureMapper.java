package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.business.dto.FeatureDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListingFeatureMapper {


    @Mapping(source = "id", target = "featureId")
    @Mapping(source = "feature.name", target = "featureName")
    @Mapping(source = "isSelected", target = "featureIsSelected")
    FeatureDto toFeatureDto(ListingFeature listingFeature);
    List<FeatureDto> toFeatureDtos(List<ListingFeature> listingFeatures);


    @Mapping(source = "featureId", target = "id")
    @Mapping(source = "featureIsSelected", target = "isSelected")
    ListingFeature toListingFeature(FeatureDto featureDto);
}