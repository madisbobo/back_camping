package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.business.dto.FeatureDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-05T09:02:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class FeatureMapperImpl implements FeatureMapper {

    @Override
    public FeatureDto toFeatureDto(Feature feature) {
        if ( feature == null ) {
            return null;
        }

        FeatureDto featureDto = new FeatureDto();

        featureDto.setFeatureId( feature.getId() );
        featureDto.setFeatureName( feature.getName() );

        featureDto.setFeatureIsSelected( false );

        return featureDto;
    }

    @Override
    public List<FeatureDto> toFeatureDtos(List<Feature> allFeatures) {
        if ( allFeatures == null ) {
            return null;
        }

        List<FeatureDto> list = new ArrayList<FeatureDto>( allFeatures.size() );
        for ( Feature feature : allFeatures ) {
            list.add( toFeatureDto( feature ) );
        }

        return list;
    }
}
