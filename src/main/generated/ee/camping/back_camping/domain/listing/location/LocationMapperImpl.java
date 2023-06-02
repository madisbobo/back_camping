package ee.camping.back_camping.domain.listing.location;

import ee.camping.back_camping.business.dto.AddFullListingDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T22:21:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public Location toLocation(AddFullListingDto addFullListingDto) {
        if ( addFullListingDto == null ) {
            return null;
        }

        Location location = new Location();

        location.setAddress( addFullListingDto.getLocationAddress() );
        location.setLatitude( addFullListingDto.getLocationLatitude() );
        location.setLongitude( addFullListingDto.getLocationLongitude() );

        return location;
    }
}
