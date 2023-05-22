package ee.camping.back_camping.domain.user.contact;

import ee.camping.back_camping.business.users.ContactDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-22T15:47:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toContact(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setImage( ContactMapper.imageDataToImage( contactDto.getImageData() ) );
        contact.setFirstName( contactDto.getFirstName() );
        contact.setLastName( contactDto.getLastName() );
        contact.setEmail( contactDto.getEmail() );
        contact.setPhoneNo( contactDto.getPhoneNo() );

        return contact;
    }
}
