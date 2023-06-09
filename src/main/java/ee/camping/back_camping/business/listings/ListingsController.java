package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.dto.*;
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

    @PutMapping("/add-listing")
    @Operation(summary = "Pooleli oleva listingule täisinfo lisamine")
    public void addFullListing(@RequestBody AddFullListingDto addFullListingDto) {
        listingsService.addFullListing(addFullListingDto);
    }


    @DeleteMapping("/add-listing")
    @Operation(summary = "Pooleli oleva listingu kustutamine", description = "Anname kaasa listingId ja kustutame listingu")
    public void deleteListing(@RequestParam Integer listingId) {
        listingsService.deleteListing(listingId);
    }



    @GetMapping("/listings")
    @Operation(summary = "Tagastab kõikide telkimisplatside preview andmed (nime, pildi, hinna, keskmise skoori ja skooride arvu)")
    public List<ListingPreviewDto> findAllActiveListingsPreview() {
        return listingsService.findAllActiveListingsPreview();

    }

    @GetMapping("/listing")
    @Operation(summary = "Tagastab kogu info ühe konkreetse listingu kohta", description = "Anname listingId ja tagastame antud listing kõik andmed")
    public ListingFullDto getListing(@RequestParam Integer listingId) {
        return listingsService.getListing(listingId);
    }

    @DeleteMapping("/my-listings")
    @Operation(summary = "Telkimisplatsi kustutamine(deaktiveerimine)", description = "Anname listingId ja märgime staatuse deaktiivseks.")
    public void deactivateListing(@RequestParam Integer listingId) {
        listingsService.deactivateListing(listingId);
    }

    @PutMapping("/edit-listing")
    @Operation(summary = "Täiendab/uuendab telkimisplatsi täisinfo")
    public void editFullListing(@RequestBody AddFullListingDto editFullListingDto) {
        listingsService.editFullListing(editFullListingDto);
    }

    @GetMapping("/listings-by-listing-id")
    @Operation(summary = "Tagastab avalehele kõikidest telkimisplatsidest neli eelvaadet",
            description = "Kuvab listingu pildi, nime (listing name), ja reitingu (average score), " +
                    "ja võimaldab neid järjestada kahanevalt listingId järgi")
    public List<ListingPreviewDto> findAllActiveListingsPreviewSortById() {
        return listingsService.findAndSortAllActiveListingsPreview();
    }
    @GetMapping("/listings-by-rating")
    @Operation(summary = "Tagastab avalehele kõikidest telkimisplatsidest neli eelvaadet",
            description = "Kuvab listingu pildi, nime (listing name), ja reitingu (average score), " +
                    "ja võimaldab neid järjestada kahanevalt reitingu järgi")
    public List<ListingPreviewDto> findAllActiveListingsPreviewSortByRating() {
        return listingsService.findAllActiveListingsPreviewSortByRating();
    }


    @GetMapping("/listings-sortby-price-asc")
    @Operation(summary = "Tagastab kõikide telkimisplatside preview andmed (nime, pildi, hinna, keskmise skoori ja skooride arvu) sorteeritult hinna alusel madalamast kõrgemaks")
    public List<ListingPreviewDto> findAllActiveListingsPreviewSortByPrice() {
        return listingsService.findAllActiveListingsPreviewSortByPrice();

    }




}
