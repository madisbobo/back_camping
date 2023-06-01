package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ListingService {

    @Resource
    private ListingRepository listingRepository;


    public List<Listing> findMyListings(Integer userId, String status) {
        return listingRepository.findListingsBy(userId, status);
    }

    public List<Listing> findAllActiveListings(String status) {
        return listingRepository.findAllListingsBy(status);
    }

    public void validateIfListingNameIsAvailable(String listingName) {
        boolean listingExists = listingRepository.listingExistsBy(listingName);
        ValidationService.validateListingNameAvailability(listingExists);
    }

    public void saveListing(Listing listing) {
        listingRepository.save(listing);
    }

    public Listing getListingBy(Integer listingId) {
        return listingRepository.findById(listingId).get();

    }

    public void deleteListing(Integer listingId) {
        listingRepository.deleteById(listingId);
    }

    public List<Listing> findAllActiveListingsSortedByPrice(String status) {
        return listingRepository.findAllByStatusOrderByPriceAsc(status);
    }

    public List<Listing> findAllActiveListingsSortedById(String status) {
        return listingRepository.findAndSortByListingIdAllListings(status);
    }
}
