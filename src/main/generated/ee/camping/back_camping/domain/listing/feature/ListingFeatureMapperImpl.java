package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.business.Dtos.FeatureDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-26T14:29:04+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ListingFeatureMapperImpl implements ListingFeatureMapper {

    @Override
    public FeatureDto toFeatureDto(ListingFeature listingFeature) {
        if ( listingFeature == null ) {
            return null;
        }

        FeatureDto featureDto = new FeatureDto();

        featureDto.setFeatureId( listingFeature.getId() );
        featureDto.setFeatureName( listingFeatureFeatureName( listingFeature ) );
        featureDto.setFeatureIsSelected( listingFeature.getIsSelected() );

        return featureDto;
    }

    @Override
    public List<FeatureDto> toFeatureDtos(List<ListingFeature> listingFeatures) {
        if ( listingFeatures == null ) {
            return null;
        }

        List<FeatureDto> list = new ArrayList<FeatureDto>( listingFeatures.size() );
        for ( ListingFeature listingFeature : listingFeatures ) {
            list.add( toFeatureDto( listingFeature ) );
        }

        return list;
    }

    private String listingFeatureFeatureName(ListingFeature listingFeature) {
        if ( listingFeature == null ) {
            return null;
        }
        Feature feature = listingFeature.getFeature();
        if ( feature == null ) {
            return null;
        }
        String name = feature.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
