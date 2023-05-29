package ee.camping.back_camping.domain.listing.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class CountyService {

    @Resource
    private CountyRepository countyRepository;

    public County getCountyBy(Integer locationCountyId) {
        return countyRepository.findById(locationCountyId).get();
    }
}
