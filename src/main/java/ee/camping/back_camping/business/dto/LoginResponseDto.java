package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto implements Serializable {
    private Integer userId;
    private String roleName;
    private Boolean profileIsCompleted;
}