package ee.camping.back_camping.domain.user.contact;

import ee.camping.back_camping.business.users.ContactDto;
import ee.camping.back_camping.util.ImageUtil;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {


    @Mapping(source = "imageData", target = "image", qualifiedByName = "imageDataToImage")
    Contact toContact(ContactDto contactDto);

    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    ContactDto toContactDto(Contact contact);

    @Mapping(source = "imageData", target = "image", qualifiedByName = "imageDataToImage")
    Contact partialUpdate(ContactDto contactDto, @MappingTarget Contact contact);

    @Named("imageDataToImage")
    static byte[] imageDataToImage(String imageData) {
        if (imageData.isEmpty()) {
            return null;
        }
        return ImageUtil.base64ImageDataToByteArray(imageData);
    }
    @Named("imageToImageData")
    static String imageToImageData(byte[] image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image);
    }



}