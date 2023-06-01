package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.business.dto.FeatureDto;
import ee.camping.back_camping.domain.listing.Listing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * A DTO for the {@link Listing} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFullListingDto implements Serializable {
    private Integer ownerUserId;
    private Integer listingId;
    private String listingName;
    private String description;
    private String additionalInfo;
    private Integer price;
    private Integer locationId;
    private Integer locationCountyId;
    private String locationAddress;
    private BigDecimal locationLongitude;
    private BigDecimal locationLatitude;

    private List<FeatureDto> features;
    private List<String> imagesData;

}
