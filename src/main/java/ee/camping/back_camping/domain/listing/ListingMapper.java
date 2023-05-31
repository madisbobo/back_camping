package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.dto.*;
import ee.camping.back_camping.business.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface ListingMapper {

    @Mapping(source = "id", target = "listingId")
    AddListingResponseDto toAddListingResponseDto(Listing listing);

    @Mapping(source = "id", target = "listingId")
    @Mapping(source = "name", target = "listingName")
    ListingPreviewDto toListingPreviewDto(Listing listing);
    List<ListingPreviewDto> toListingPreviewDtos(List<Listing> myListings);


    @Mapping(source = "name", target = "listingName")
    @Mapping(source = "description", target = "listingDescription")
    @Mapping(source = "additionalInfo", target = "listingAdditionalInfo")
    @Mapping(source = "location.county.name", target = "countyName")
    @Mapping(source = "location.address", target = "locationAddress")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    @Mapping(source = "ownerUser.id", target = "ownerId")
    ListingFullDto tolistingFullDto(Listing listing);

    @Mapping(source = "listingName", target = "name")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    Listing toListing(NewListingDto newListingDto);


    @Mapping(source = "listingName", target = "name")
    @Mapping(source = "listingId", target = "id")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    Listing toFullListing(AddFullListingDto addFullListingDto);

    @Mapping(source = "location.county.id", target = "locationCountyId")
    @Mapping(source = "location.address", target = "locationAddress")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    EditListingResponseDto toEditListingResponseDto(Listing listing);
}