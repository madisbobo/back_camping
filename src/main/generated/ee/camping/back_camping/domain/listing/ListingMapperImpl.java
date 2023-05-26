package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.listings.AddListingResponseDto;
import ee.camping.back_camping.business.listings.ListingPreviewDto;
import ee.camping.back_camping.business.listings.NewListingDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-26T08:07:30+0300",
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

    @Override
    public Listing toListing(NewListingDto newListingDto) {
        if ( newListingDto == null ) {
            return null;
        }

        Listing listing = new Listing();

        listing.setName( newListingDto.getListingName() );

        listing.setStatus( Status.ACTIVE.getLetter() );

        return listing;
    }

    @Override
    public AddListingResponseDto toAddListingResponseDto(Listing listing) {
        if ( listing == null ) {
            return null;
        }

        AddListingResponseDto addListingResponseDto = new AddListingResponseDto();

        addListingResponseDto.setListingId( listing.getId() );

        return addListingResponseDto;
    }
}
