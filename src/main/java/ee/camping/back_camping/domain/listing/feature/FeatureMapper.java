package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.business.dto.FeatureDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeatureMapper {

    @Mapping(source = "id", target = "featureId")
    @Mapping(source = "name", target = "featureName")
    @Mapping(constant = "false", target = "featureIsSelected")
    FeatureDto toFeatureDto(Feature feature);
    List<FeatureDto> toFeatureDtos(List<Feature> allFeatures);
}