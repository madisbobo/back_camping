package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.dto.FeatureDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class EditListingResponseDto implements Serializable {
    private Integer locationId;
    private Integer locationCountyId;
    @Size(max = 255)
    @NotNull
    private String locationAddress;
    @NotNull
    private BigDecimal locationLongitude;
    @NotNull
    private BigDecimal locationLatitude;
    @Size(max = 500)
    private String description;
    @Size(max = 500)
    private String additionalInfo;
    private Integer price;
    private List<FeatureDto> features;
    private List<String> imagesData;
}