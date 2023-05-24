package ee.camping.back_camping.domain.listing.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public Image findCoverImagesBy(Integer listingId) {
        return imageRepository.findImageBy(listingId);
    }
}
