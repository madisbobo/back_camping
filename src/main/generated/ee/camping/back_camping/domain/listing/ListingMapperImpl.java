package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.Dtos.AddListingResponseDto;
import ee.camping.back_camping.business.Dtos.ListingFullDto;
import ee.camping.back_camping.business.Dtos.ListingPreviewDto;
import ee.camping.back_camping.business.Dtos.NewListingDto;
import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.domain.listing.location.County;
import ee.camping.back_camping.domain.listing.location.Location;
import ee.camping.back_camping.domain.user.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-26T16:33:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ListingMapperImpl implements ListingMapper {

    @Override
    public AddListingResponseDto toAddListingResponseDto(Listing listing) {
        if ( listing == null ) {
            return null;
        }

        AddListingResponseDto addListingResponseDto = new AddListingResponseDto();

        addListingResponseDto.setListingId( listing.getId() );

        return addListingResponseDto;
    }

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
    public ListingFullDto tolistingFullDto(Listing listing) {
        if ( listing == null ) {
            return null;
        }

        ListingFullDto listingFullDto = new ListingFullDto();

        listingFullDto.setListingName( listing.getName() );
        listingFullDto.setListingDescription( listing.getDescription() );
        listingFullDto.setListingAdditionalInfo( listing.getAdditionalInfo() );
        listingFullDto.setCountyName( listingLocationCountyName( listing ) );
        listingFullDto.setLocationAddress( listingLocationAddress( listing ) );
        listingFullDto.setLocationLongitude( listingLocationLongitude( listing ) );
        listingFullDto.setLocationLatitude( listingLocationLatitude( listing ) );
        Integer id = listingOwnerUserId( listing );
        if ( id != null ) {
            listingFullDto.setOwnerId( String.valueOf( id ) );
        }
        listingFullDto.setPrice( listing.getPrice() );

        return listingFullDto;
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

    private String listingLocationCountyName(Listing listing) {
        if ( listing == null ) {
            return null;
        }
        Location location = listing.getLocation();
        if ( location == null ) {
            return null;
        }
        County county = location.getCounty();
        if ( county == null ) {
            return null;
        }
        String name = county.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String listingLocationAddress(Listing listing) {
        if ( listing == null ) {
            return null;
        }
        Location location = listing.getLocation();
        if ( location == null ) {
            return null;
        }
        String address = location.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private BigDecimal listingLocationLongitude(Listing listing) {
        if ( listing == null ) {
            return null;
        }
        Location location = listing.getLocation();
        if ( location == null ) {
            return null;
        }
        BigDecimal longitude = location.getLongitude();
        if ( longitude == null ) {
            return null;
        }
        return longitude;
    }

    private BigDecimal listingLocationLatitude(Listing listing) {
        if ( listing == null ) {
            return null;
        }
        Location location = listing.getLocation();
        if ( location == null ) {
            return null;
        }
        BigDecimal latitude = location.getLatitude();
        if ( latitude == null ) {
            return null;
        }
        return latitude;
    }

    private Integer listingOwnerUserId(Listing listing) {
        if ( listing == null ) {
            return null;
        }
        User ownerUser = listing.getOwnerUser();
        if ( ownerUser == null ) {
            return null;
        }
        Integer id = ownerUser.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
