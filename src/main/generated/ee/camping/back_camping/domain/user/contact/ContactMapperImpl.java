package ee.camping.back_camping.domain.user.contact;

import ee.camping.back_camping.business.Dtos.ContactDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-26T08:07:30+0300",
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

    @Override
    public ContactDto toContactDto(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactDto contactDto = new ContactDto();

        contactDto.setImageData( ContactMapper.imageToImageData( contact.getImage() ) );
        contactDto.setFirstName( contact.getFirstName() );
        contactDto.setLastName( contact.getLastName() );
        contactDto.setEmail( contact.getEmail() );
        contactDto.setPhoneNo( contact.getPhoneNo() );

        return contactDto;
    }

    @Override
    public Contact partialUpdate(ContactDto contactDto, Contact contact) {
        if ( contactDto == null ) {
            return contact;
        }

        contact.setImage( ContactMapper.imageDataToImage( contactDto.getImageData() ) );
        contact.setFirstName( contactDto.getFirstName() );
        contact.setLastName( contactDto.getLastName() );
        contact.setEmail( contactDto.getEmail() );
        contact.setPhoneNo( contactDto.getPhoneNo() );

        return contact;
    }
}
