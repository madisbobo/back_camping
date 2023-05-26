package ee.camping.back_camping.business.Dtos;

import ee.camping.back_camping.domain.user.contact.Contact;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Contact} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto implements Serializable {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String imageData;
}