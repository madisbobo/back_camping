package ee.camping.back_camping.domain.review;

import ee.camping.back_camping.business.listings.RatingDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-24T12:41:37+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public RatingDto toRatingDto(Review review) {
        if ( review == null ) {
            return null;
        }

        RatingDto ratingDto = new RatingDto();

        ratingDto.setRating( review.getScore() );

        return ratingDto;
    }

    @Override
    public List<RatingDto> toRatingsDto(List<Review> reviews) {
        if ( reviews == null ) {
            return null;
        }

        List<RatingDto> list = new ArrayList<RatingDto>( reviews.size() );
        for ( Review review : reviews ) {
            list.add( toRatingDto( review ) );
        }

        return list;
    }
}
