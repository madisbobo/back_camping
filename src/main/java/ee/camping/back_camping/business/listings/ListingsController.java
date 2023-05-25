package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/my-listings")
    @Operation(summary = "Uue telkimisplatsi lisamine", description = "Anname kaasa userId ja listingName ning tagastame listingId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega telkimisplats on juba süsteemis olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public AddListingResponseDto addListing(@RequestBody NewListingDto newListingDto) {
        return listingsService.addListing(newListingDto);
    }

    @GetMapping("/listings")
    @Operation(summary = "Tagastab kõikide telkimisplatside preview andmed (nime, pildi, hinna, keskmise skoori ja skooride arvu)")
    public List<ListingPreviewDto> findAllActiveListingsPreview() {
        return listingsService.findAllActiveListingsPreview();

    }




}
