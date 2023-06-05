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
public class ListingFeatureMapperImpl implements ListingFeatureMapper {

    @Override
    public FeatureDto toFeatureDto(ListingFeature listingFeature) {
        if ( listingFeature == null ) {
            return null;
        }

        FeatureDto featureDto = new FeatureDto();

        featureDto.setFeatureId( listingFeatureFeatureId( listingFeature ) );
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

    @Override
    public ListingFeature toListingFeature(FeatureDto featureDto) {
        if ( featureDto == null ) {
            return null;
        }

        ListingFeature listingFeature = new ListingFeature();

        listingFeature.setId( featureDto.getFeatureId() );
        listingFeature.setIsSelected( featureDto.getFeatureIsSelected() );

        return listingFeature;
    }

    private Integer listingFeatureFeatureId(ListingFeature listingFeature) {
        if ( listingFeature == null ) {
            return null;
        }
        Feature feature = listingFeature.getFeature();
        if ( feature == null ) {
            return null;
        }
        Integer id = feature.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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
