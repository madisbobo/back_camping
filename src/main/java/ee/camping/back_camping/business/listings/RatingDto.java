package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.domain.review.Review;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Review} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto implements Serializable {
    private Integer rating;
}