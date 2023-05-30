package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.dto.CountyDto;
import ee.camping.back_camping.domain.listing.feature.Feature;
import ee.camping.back_camping.domain.listing.location.County;
import ee.camping.back_camping.domain.listing.location.CountyMapper;
import ee.camping.back_camping.domain.listing.location.CountyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CountiesService {


    @Resource
    private CountyService countyService;

    @Resource
    private CountyMapper countyMapper;


    public List<CountyDto> getAllCounties() {
        List<County> allCounties = countyService.getAllCounties();
        return countyMapper.toCountyDtos(allCounties);
    }

}
