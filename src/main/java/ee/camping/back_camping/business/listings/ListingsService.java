package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.Dtos.*;
import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.domain.listing.*;
import ee.camping.back_camping.domain.listing.feature.ListingFeature;
import ee.camping.back_camping.domain.listing.feature.ListingFeatureMapper;
import ee.camping.back_camping.domain.listing.feature.ListingFeatureService;
import ee.camping.back_camping.domain.listing.image.Image;
import ee.camping.back_camping.domain.listing.image.ImageMapper;
import ee.camping.back_camping.domain.listing.image.ImageService;
import ee.camping.back_camping.domain.review.ScoreInfo;
import ee.camping.back_camping.domain.review.ReviewService;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserService;
import ee.camping.back_camping.domain.user.contact.Contact;
import ee.camping.back_camping.domain.user.contact.ContactMapper;
import ee.camping.back_camping.domain.user.contact.ContactService;
import ee.camping.back_camping.util.ImageUtil;
import ee.camping.back_camping.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Resource
    private ListingFeatureService listingFeatureService;

    @Resource
    private ListingFeatureMapper listingFeatureMapper;

    @Resource
    private ContactService contactService;

    @Resource
    private ContactMapper contactMapper;


    public AddListingResponseDto addListing(NewListingDto newListingDto) {
        listingService.validateIfListingNameIsAvailable(newListingDto.getListingName());
        Listing listing = listingMapper.toListing(newListingDto);
        User user = userService.findUserBy(newListingDto.getOwnerUserId());
        listing.setOwnerUser(user);
        listingService.addListing(listing);
        return listingMapper.toAddListingResponseDto(listing);
    }

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


    public ListingFullDto getListing(Integer listingId) {
        Listing listing = listingService.getListingBy(listingId);
        ListingFullDto listingFullDto = listingMapper.tolistingFullDto(listing);

        Contact contact = contactService.getUserContactBy(listing.getOwnerUser().getId());
        ContactDto contactDto = contactMapper.toContactDto(contact);
        listingFullDto.setContact(contactDto);

        addRating(listingId, listingFullDto);
        addImages(listingId, listingFullDto);
        addFeatures(listingId, listingFullDto);
        return listingFullDto;


    }



    // ************** PRIVATE METHODS ************** //
    private void addFeatures(Integer listingId, ListingFullDto listingFullDto) {
        List<ListingFeature> listingFeatures = listingFeatureService.findListingFeaturesBy(listingId);
        List<FeatureDto> featureDtos = listingFeatureMapper.toFeatureDtos(listingFeatures);
        listingFullDto.setFeatures(featureDtos);
    }

    private void addImages(Integer listingId, ListingFullDto listingFullDto) {
        List<Image> images = imageService.findImagesBy(listingId);
        List<String> imagesData = new ArrayList<>();
        for (Image image : images) {
            String imageData = ImageUtil.byteArrayToBase64ImageData(image.getData());
            imagesData.add(imageData);
        }
        listingFullDto.setImagesData(imagesData);
    }


    private void addListingImages(List<ListingPreviewDto> listingPreviewDtos) {
        for (ListingPreviewDto listingPreviewDto : listingPreviewDtos) {
            Image coverImage = imageService.findCoverImagesBy(listingPreviewDto.getListingId());
            String imageData = ImageUtil.byteArrayToBase64ImageData(coverImage.getData());
            listingPreviewDto.setImageData(imageData);
        }
    }

    private void addRating(Integer listingId, ListingFullDto listingFullDto) {
        ScoreInfo scoreInfo = reviewService.findScoreInfo(listingId);
        listingFullDto.setNumberOfScores(scoreInfo.getNumberOfScores());
        if (scoreInfo.getAverageScore() == null) {
            listingFullDto.setAverageScore(0.0);
        } else {
            listingFullDto.setAverageScore(scoreInfo.getAverageScore() * 10 / 10.0);
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


    public void deleteListing(Integer listingId) {
        listingService.deleteListing(listingId);
    }
}
