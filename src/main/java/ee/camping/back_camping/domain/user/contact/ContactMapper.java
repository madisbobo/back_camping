package ee.camping.back_camping.domain.user.contact;

import ee.camping.back_camping.business.users.ContactDto;
import ee.camping.back_camping.util.ImageUtil;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {


    @Mapping(source = "imageData", target = "image", qualifiedByName = "imageDataToImage")
    Contact toContact(ContactDto contactDto);

    @Named("imageDataToImage")
    static byte[] imageDataToImage(String imageData) {
        if (imageData.isEmpty()) {
            return null;
        }
        return ImageUtil.base64ImageDataToByteArray(imageData);
    }

}