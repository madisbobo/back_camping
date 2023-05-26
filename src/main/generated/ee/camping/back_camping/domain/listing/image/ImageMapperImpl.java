package ee.camping.back_camping.domain.listing.image;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-26T08:07:30+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDto toImageDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        imageDto.setImageData( ImageMapper.imageToImageData( image.getData() ) );

        return imageDto;
    }

    @Override
    public List<ImageDto> toImagesDto(List<Image> listingImages) {
        if ( listingImages == null ) {
            return null;
        }

        List<ImageDto> list = new ArrayList<ImageDto>( listingImages.size() );
        for ( Image image : listingImages ) {
            list.add( toImageDto( image ) );
        }

        return list;
    }
}
