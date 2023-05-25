package ee.camping.back_camping.domain.listing.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CountyService {
    @Resource
    private CountyRepository countyRepository;

    public County findCountyBy(String countyName) {
        return countyRepository.findCountyBy(countyName);
    }
}
