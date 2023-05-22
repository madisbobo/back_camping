package ee.camping.back_camping.business.users;

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
    @Size(max = 255)
    @NotNull
    private String firstName;
    @Size(max = 255)
    @NotNull
    private String lastName;
    @Size(max = 255)
    @NotNull
    private String email;
    @Size(max = 15)
    private String phoneNo;
    private String imageData;
}