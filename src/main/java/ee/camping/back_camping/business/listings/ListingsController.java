package ee.camping.back_camping.business.listings;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListingsController {
    @Resource
    private ListingsService listingsService;

    @GetMapping("/my-listings")
    @Operation(summary = "Tagastab userId järgi kasutaja telkimisplatsi preview andmed (nime, pildi, hinna, keskmise skoori ja skooride arvu)")
    public List<ListingPreviewDto> findMyListingsPreview(@RequestParam Integer userId) {
        return listingsService.findMyListingsPreview(userId);

    }

    @GetMapping("/listings")
    @Operation(summary = "Tagastab kõikide telkimisplatside preview andmed (nime, pildi, hinna, keskmise skoori ja skooride arvu)")
    public List<ListingPreviewDto> findAllActiveListingsPreview() {
        return listingsService.findAllActiveListingsPreview();

    }


}
