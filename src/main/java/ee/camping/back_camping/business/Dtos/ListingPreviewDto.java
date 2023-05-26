package ee.camping.back_camping.business.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Listing} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListingPreviewDto implements Serializable {
    private Integer listingId;
    private String listingName;
    private Integer price;
    private String imageData;
    private Long numberOfScores;
    private Double averageScore;
}