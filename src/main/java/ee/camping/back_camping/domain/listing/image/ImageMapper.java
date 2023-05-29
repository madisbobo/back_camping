package ee.camping.back_camping.domain.listing.image;

import ee.camping.back_camping.business.dto.ImageDto;
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

    @Named("imageDataToImage")
    static byte[] imageDataToImage(String imageData) {
        if (imageData == null) {
            return null;
        }
        return ImageUtil.base64ImageDataToByteArray(imageData);
    }



}