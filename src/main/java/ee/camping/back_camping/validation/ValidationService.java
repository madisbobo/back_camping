package ee.camping.back_camping.validation;

import ee.camping.back_camping.domain.listing.Listing;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidationService {

    public static void validateUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(Error.UNVALIDATED_CREDENTIALS.getMessage(), Error.UNVALIDATED_CREDENTIALS.getErrorCode());
        }
    }

    public static void validateUsernameAvailability(boolean userExists) {
        if (userExists) {
            throw new BusinessException(Error.USERNAME_UNAVAILABLE.getMessage(), Error.USERNAME_UNAVAILABLE.getErrorCode());
        }
    }

}
