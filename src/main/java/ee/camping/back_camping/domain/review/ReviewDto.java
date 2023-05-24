package ee.camping.back_camping.domain.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ReviewDto implements Serializable {
    private Long numberOfScores;
    private Double averageScore;

    public ReviewDto(Long numberOfScores, Double averageScore) {
        this.numberOfScores = numberOfScores;
        this.averageScore = averageScore;
    }
}
