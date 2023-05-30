package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.dto.CountyDto;
import ee.camping.back_camping.domain.listing.location.County;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountyController {

    @Resource
    private CountiesService countiesService;

    @GetMapping("/add-listing-counties")
    @Operation(summary = "Tagastab kõik maakonnad (ID, nimi)")
    public List<CountyDto> getAllCounties() {
        return countiesService.getAllCounties();
    }

}
