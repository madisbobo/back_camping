package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.listings.ListingPreviewDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-25T10:41:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ListingMapperImpl implements ListingMapper {

    @Override
    public ListingPreviewDto toListingPreviewDto(Listing listing) {
        if ( listing == null ) {
            return null;
        }

        ListingPreviewDto listingPreviewDto = new ListingPreviewDto();

        listingPreviewDto.setListingId( listing.getId() );
        listingPreviewDto.setListingName( listing.getName() );
        listingPreviewDto.setPrice( listing.getPrice() );

        return listingPreviewDto;
    }

    @Override
    public List<ListingPreviewDto> toListingPreviewDtos(List<Listing> myListings) {
        if ( myListings == null ) {
            return null;
        }

        List<ListingPreviewDto> list = new ArrayList<ListingPreviewDto>( myListings.size() );
        for ( Listing listing : myListings ) {
            list.add( toListingPreviewDto( listing ) );
        }

        return list;
    }
}
