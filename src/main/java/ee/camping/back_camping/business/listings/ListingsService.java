package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.domain.listing.*;
import ee.camping.back_camping.domain.listing.image.Image;
import ee.camping.back_camping.domain.listing.image.ImageMapper;
import ee.camping.back_camping.domain.listing.image.ImageService;
import ee.camping.back_camping.domain.review.ScoreInfo;
import ee.camping.back_camping.domain.review.ReviewService;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserService;
import ee.camping.back_camping.util.ImageUtil;
import ee.camping.back_camping.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingsService {

    @Resource
    private ListingService listingService;
    @Resource
    private ImageService imageService;
    @Resource
    private ReviewService reviewService;
    @Resource
    private ListingMapper listingMapper;

    @Resource
    private ImageMapper imageMapper;

    @Resource
    private UserService userService;

    @Resource
    private ValidationService validationService;


    public List<ListingPreviewDto> findMyListingsPreview(Integer userId) {
        List<Listing> myListings = listingService.findMyListings(userId);
        List<ListingPreviewDto> listingPreviewDtos = listingMapper.toListingPreviewDtos(myListings);
        addListingImages(listingPreviewDtos);
        addRatings(listingPreviewDtos);
        return listingPreviewDtos;
    }

    public List<ListingPreviewDto> findAllActiveListingsPreview() {
        List<Listing> allActiveListings = listingService.findAllActiveListings(Status.ACTIVE.getLetter());
        List<ListingPreviewDto> listingPreviewDtos = listingMapper.toListingPreviewDtos(allActiveListings);
        addListingImages(listingPreviewDtos);
        addRatings(listingPreviewDtos);
        return listingPreviewDtos;
    }


    private void addListingImages(List<ListingPreviewDto> listingPreviewDtos) {
        for (ListingPreviewDto listingPreviewDto : listingPreviewDtos) {
            Image coverImage = imageService.findCoverImagesBy(listingPreviewDto.getListingId());
            String imageData = ImageUtil.byteArrayToBase64ImageData(coverImage.getData());
            listingPreviewDto.setImageData(imageData);
        }
    }

    private void addRatings(List<ListingPreviewDto> listingPreviewDtos) {
        for (ListingPreviewDto listingPreviewDto : listingPreviewDtos) {
            ScoreInfo scoreInfo = reviewService.findScoreInfo(listingPreviewDto.getListingId());
            listingPreviewDto.setNumberOfScores(scoreInfo.getNumberOfScores());
            if (scoreInfo.getAverageScore() == null) {
                listingPreviewDto.setAverageScore(0.0);
            } else {
                listingPreviewDto.setAverageScore(Math.round(scoreInfo.getAverageScore() * 10.0) / 10.0);
            }
        }
    }


    public AddListingResponseDto addListing(NewListingDto newListingDto) {
        listingService.validateIfListingNameIsAvailable(newListingDto.getListingName());
        Listing listing = listingMapper.toListing(newListingDto);
        User user = userService.findUserBy(newListingDto.getOwnerUserId());
        listing.setOwnerUser(user);
        listingService.addListing(listing);
        return listingMapper.toAddListingResponseDto(listing);
    }


}
