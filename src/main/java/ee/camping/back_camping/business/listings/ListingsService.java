package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.dto.*;
import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.domain.listing.*;
import ee.camping.back_camping.domain.listing.feature.*;
import ee.camping.back_camping.domain.listing.image.Image;
import ee.camping.back_camping.domain.listing.image.ImageMapper;
import ee.camping.back_camping.domain.listing.image.ImageService;
import ee.camping.back_camping.domain.listing.location.*;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
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

    @Resource
    private LocationMapper locationMapper;

    @Resource
    private CountyService countyService;

    @Resource
    private FeatureService featureService;

    @Resource
    private LocationService locationService;
    private final ListingFeatureRepository listingFeatureRepository;
    private final LocationRepository locationRepository;

    public ListingsService(ListingFeatureRepository listingFeatureRepository,
                           LocationRepository locationRepository) {
        this.listingFeatureRepository = listingFeatureRepository;
        this.locationRepository = locationRepository;
    }


    public AddListingResponseDto addListing(NewListingDto newListingDto) {
        listingService.validateIfListingNameIsAvailable(newListingDto.getListingName());
        Listing listing = listingMapper.toListing(newListingDto);
        User user = userService.findUserBy(newListingDto.getOwnerUserId());
        listing.setOwnerUser(user);
        listingService.saveListing(listing);
        return listingMapper.toAddListingResponseDto(listing);
    }

    public List<ListingPreviewDto> findMyListingsPreview(Integer userId) {
        List<Listing> myListings = listingService.findMyListings(userId, Status.ACTIVE.getLetter());
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

    public List<ListingPreviewDto> findAllActiveListingsPreviewSortByPrice() {
        List<Listing> allActiveListings = listingService.findAllActiveListingsSortedByPrice(Status.ACTIVE.getLetter());
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

    @Transactional
    public void addFullListing(AddFullListingDto addFullListingDto) {
        Listing listing = listingMapper.toFullListing(addFullListingDto);

        // Find and set user to listing
        User user = userService.findUserBy(addFullListingDto.getOwnerUserId());
        listing.setOwnerUser(user);

        // Find, save and set location to listing
        Location location = locationMapper.toLocation(addFullListingDto);
        County county = countyService.getCountyBy(addFullListingDto.getLocationCountyId());
        location.setCounty(county);
        locationService.saveLocation(location);
        listing.setLocation(location);

        // save/write over the existing listing in the database
        listingService.saveListing(listing);

        // Create listing feature object, put relevant data into it and save it to the db
        List<ListingFeature> listingFeatures = createListingFeatures(addFullListingDto, listing);
        listingFeatureService.saveListingFeatures(listingFeatures);

        // Create image object, put images into it and save it to the db
        List<Image> images = createImages(addFullListingDto, listing);
        imageService.saveImages(images);

    }

    @Transactional
    public void editFullListing(AddFullListingDto editFullListingDto) {
        Listing listing = listingMapper.toFullListing(editFullListingDto);

        // Delete existing features and images
        listingFeatureService.deleteAllBy(listing);
        imageService.deleteAllBy(listing);

        // Find and set user to listing
        User user = userService.findUserBy(editFullListingDto.getOwnerUserId());
        listing.setOwnerUser(user);

        // Find, save and set location to listing
        Location location = locationMapper.toLocation(editFullListingDto);
        County county = countyService.getCountyBy(editFullListingDto.getLocationCountyId());
        location.setCounty(county);
        locationService.saveLocation(location);
        listing.setLocation(location);

        // save/write over the existing listing in the database
        listingService.saveListing(listing);


        // Delete the old location
        locationRepository.deleteById(editFullListingDto.getLocationId());



        // Create listing feature object, put relevant data into it and save it to the db
        List<ListingFeature> listingFeatures = createListingFeatures(editFullListingDto, listing);
        listingFeatureService.saveListingFeatures(listingFeatures);

        // Create image object, put images into it and save it to the db
        List<Image> images = createImages(editFullListingDto, listing);
        imageService.saveImages(images);


    }


    private List<Image> createImages(AddFullListingDto addFullListingDto, Listing listing) {
        List<Image> images = new ArrayList<>();
        for (String imageData : addFullListingDto.getImagesData()) {
            Image image = new Image();
            byte[] data = ImageUtil.base64ImageDataToByteArray(imageData);
            image.setData(data);
            image.setListing(listing);
            images.add(image);
        }
        return images;
    }

    private List<ListingFeature> createListingFeatures(AddFullListingDto addFullListingDto, Listing listing) {
        // Set features
        List<ListingFeature> listingFeatures = new ArrayList<>();
        for (FeatureDto featureDto : addFullListingDto.getFeatures()) {

            ListingFeature listingFeature = new ListingFeature();

            // find and set feature to listing_feature
            Feature feature = featureService.getFeatureby(featureDto.getFeatureId());
            listingFeature.setFeature(feature);
            listingFeature.setIsSelected(featureDto.getFeatureIsSelected());

            // set listing to listing_feature
            listingFeature.setListing(listing);

            // add listingFeature to listingFeatures
            listingFeatures.add(listingFeature);

        }
        return listingFeatures;
    }

    public void deleteListing(Integer listingId) {
        listingService.deleteListing(listingId);
    }

    public void deactivateListing(Integer listingId) {
        Listing listing = listingService.getListingBy(listingId);
        listing.setStatus(Status.DELETED.getLetter());
        listingService.saveListing(listing);
    }


    //ASDASDAS
    public List<ListingPreviewDto> findAndSortAllActiveListingsPreview() {
        List<Listing> allActiveListingsSortedById = listingService.findAllActiveListingsSortedById(Status.ACTIVE.getLetter());
        List<ListingPreviewDto> listingPreviewDtos = listingMapper.toListingPreviewDtos(allActiveListingsSortedById);
        addListingImages(listingPreviewDtos);
        addRatings(listingPreviewDtos);
        return listingPreviewDtos;
    }


    //ASDASDAS
    public List<ListingPreviewDto> findAllActiveListingsPreviewSortByRating() {
        List<Listing> allActiveListings = listingService.findAllActiveListings(Status.ACTIVE.getLetter());
        List<ListingPreviewDto> listingPreviewDtos = listingMapper.toListingPreviewDtos(allActiveListings);
        addListingImages(listingPreviewDtos);
        addRatings(listingPreviewDtos);
        listingPreviewDtos.sort(Comparator.comparingDouble(ListingPreviewDto::getAverageScore).reversed());

        if (listingPreviewDtos.size() > 2) {
            return listingPreviewDtos.subList(0, 2);
        }
        return listingPreviewDtos;
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

            if (coverImage == null) {
                listingPreviewDto.setImageData("");
            } else {
                String imageData = ImageUtil.byteArrayToBase64ImageData(coverImage.getData());
                listingPreviewDto.setImageData(imageData);
            }
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



}
