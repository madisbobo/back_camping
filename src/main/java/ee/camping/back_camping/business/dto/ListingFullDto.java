package ee.camping.back_camping.business.dto;

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
public class ListingFullDto implements Serializable {
    private String listingName;
    private String listingDescription;
    private String listingAdditionalInfo;
    private Long numberOfScores;
    private Double averageScore;

    private List <String> imagesData;
    private List <FeatureDto> features;

    private String countyName;
    private String locationAddress;
    private BigDecimal locationLongitude;
    private BigDecimal locationLatitude;

    private String ownerId;
    private ContactDto contact;
    private Integer price;


}