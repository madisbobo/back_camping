package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.listing.location.County;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link County} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyDto implements Serializable {
    private Integer countyId;
    private String countyName;
}