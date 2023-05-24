package ee.camping.back_camping.domain.review;

import ee.camping.back_camping.business.listings.RatingDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {


    @Mapping(source = "score", target = "rating")
    RatingDto toRatingDto(Review review);

    List<RatingDto> toRatingsDto(List<Review> reviews);
}