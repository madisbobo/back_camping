package ee.camping.back_camping.domain.listing.location;

import ee.camping.back_camping.business.dto.CountyDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountyService {

    @Resource
    private CountyRepository countyRepository;

    public County getCountyBy(Integer locationCountyId) {
        return countyRepository.findById(locationCountyId).get();
    }

    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }
}
