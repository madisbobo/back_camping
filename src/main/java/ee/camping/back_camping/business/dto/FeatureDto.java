package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.listing.feature.Feature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Feature} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDto implements Serializable {
    private Integer featureId;
    private String featureName;
    private Boolean featureIsSelected;
}