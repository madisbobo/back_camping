package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.listings.AddListingResponseDto;
import ee.camping.back_camping.business.listings.ListingPreviewDto;
import ee.camping.back_camping.business.listings.NewListingDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface ListingMapper {

    @Mapping(source = "id", target = "listingId")
    @Mapping(source = "name", target = "listingName")
    ListingPreviewDto toListingPreviewDto(Listing listing);

    List<ListingPreviewDto> toListingPreviewDtos(List<Listing> myListings);

    @Mapping(source = "listingName", target = "name")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    Listing toListing(NewListingDto newListingDto);

    @Mapping(source = "id", target = "listingId")
    AddListingResponseDto toAddListingResponseDto(Listing listing);

}