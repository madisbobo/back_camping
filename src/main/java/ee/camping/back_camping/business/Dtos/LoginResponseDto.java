package ee.camping.back_camping.business.Dtos;

import ee.camping.back_camping.domain.user.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class LoginResponseDto implements Serializable {
    private final Integer userId;
    @Size(max = 255)
    @NotNull
    private final String roleName;
}