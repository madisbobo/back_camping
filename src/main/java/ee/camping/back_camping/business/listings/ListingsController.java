package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.dto.AddListingResponseDto;
import ee.camping.back_camping.business.Dtos.ListingFullDto;
import ee.camping.back_camping.business.Dtos.ListingPreviewDto;
import ee.camping.back_camping.business.dto.NewListingDto;
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
    @Operation(summary = "Tagastab userId järgi kasutaja telkimisplatsi nime, pildi ja reitingu")
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

    @DeleteMapping("/add-listing")
    @Operation(summary = "Pooleli oleva listingu kustutamine", description = "Anname kaasa listingId ja kustutame listingu")
    public void deleteListing(@RequestParam Integer listingId) {
        listingsService.deleteListing(listingId);
    }

    @GetMapping("/listings")
    @Operation(summary = "Tagastab kõikide telkimisplatside eelvaate",
            description = "Kuvab listingu pildi, nime (listing name), ja reitingu (average score)")
    public List<ListingPreviewDto> findAllActiveListingsPreview() {
        return listingsService.findAllActiveListingsPreview();
    }

    @GetMapping("/listing")
    @Operation(summary = "Tagastab kogu info ühe konkreetse listingu kohta", description = "Anname listingId ja tagastame antud listing kõik andmed")
    public ListingFullDto getListing(@RequestParam Integer listingId) {
        return listingsService.getListing(listingId);
    }
}
