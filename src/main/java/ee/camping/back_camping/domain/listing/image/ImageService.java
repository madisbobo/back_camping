package ee.camping.back_camping.domain.listing.image;

import ee.camping.back_camping.domain.listing.Listing;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public Image findCoverImagesBy(Integer listingId) {
        return imageRepository.findImageBy(listingId);
    }

    public List<Image> findImagesBy(Integer listingId) {
        return imageRepository.findImagesBy(listingId);

    }

    public void saveImages(List<Image> images) {
        imageRepository.saveAll(images);
    }

    public void deleteAllBy(Listing listing) {
        imageRepository.deleteAllBy(listing);
    }
}
