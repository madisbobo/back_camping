package ee.camping.back_camping.business.users;

import ee.camping.back_camping.business.login.LoginResponseDto;
import ee.camping.back_camping.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/signup")
    @Operation(summary = "Uue kasutaja lisamine", description = "Anname kaasa username ja password ning lisame uue kasutaja ning tagastama tema userId ja RoleName-i. Kui sellise kasutajanimega kasutaja juba eksisteerib, tagastame errori 222")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise kasutajanimega kasutaja on juba süsteemis olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponseDto addUser(@RequestBody NewUserDto newUserDto) {
        return usersService.addUser(newUserDto);
    }

    @PostMapping("/signup-info")
    @Operation(summary = "Uue kasutaja info lisamine", description = "Anname kaasa userId, eesnime, perekonnanime, e-posti, telefoni nr-i (optional) ja profiilipildi (optional)")
    public void addUserContact(@RequestBody ContactDto contactDto) {
        usersService.addUserContact(contactDto);
    }
}
