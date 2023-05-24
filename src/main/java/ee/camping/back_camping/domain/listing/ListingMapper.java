package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.listings.ListingPreviewDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListingMapper {

    @Mapping(source = "id", target = "listingId")
    @Mapping(source = "name", target = "listingName")
    ListingPreviewDto toListingPreviewDto(Listing listing);

    List<ListingPreviewDto> toListingPreviewDtos(List<Listing> myListings);

}