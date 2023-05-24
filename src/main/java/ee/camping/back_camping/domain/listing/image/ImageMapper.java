package ee.camping.back_camping.domain.listing.image;

import ee.camping.back_camping.business.users.ContactDto;
import ee.camping.back_camping.domain.user.contact.Contact;
import ee.camping.back_camping.util.ImageUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {

    @Mapping(source = "data", target = "imageData", qualifiedByName = "imageToImageData")
    ImageDto toImageDto(Image image);

    List<ImageDto> toImagesDto(List<Image> listingImages);



    @Named("imageToImageData")
    static String imageToImageData(byte[] data) {
        if (data == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(data);
    }




}