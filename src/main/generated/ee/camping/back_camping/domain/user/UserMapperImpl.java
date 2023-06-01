package ee.camping.back_camping.domain.user;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.dto.LoginResponseDto;
import ee.camping.back_camping.business.dto.NewUserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T15:56:42+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponseDto toLoginResponseDto(User user, Boolean profileIsCompleted) {
        if ( user == null && profileIsCompleted == null ) {
            return null;
        }

        LoginResponseDto loginResponseDto = new LoginResponseDto();

        loginResponseDto.setUserId( user.getId() );
        loginResponseDto.setRoleName( user.getRole().getName() );
        loginResponseDto.setProfileIsCompleted( profileIsCompleted );

        return loginResponseDto;
    }

    @Override
    public User toUser(NewUserDto newUserDto) {
        if ( newUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( newUserDto.getUsername() );
        user.setPassword( newUserDto.getPassword() );

        user.setStatus( Status.ACTIVE.getLetter() );

        return user;
    }
}
