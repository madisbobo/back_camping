package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.listing.Listing;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Listing} entity
 */
@Data
public class NewListingDto implements Serializable {
    private  Integer ownerUserId;

    private  String listingName;
}