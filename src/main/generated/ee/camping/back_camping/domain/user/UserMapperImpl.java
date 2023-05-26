package ee.camping.back_camping.domain.user;

import ee.camping.back_camping.business.Dtos.LoginResponseDto;
import ee.camping.back_camping.business.Dtos.NewUserDto;
import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.domain.user.role.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-26T14:16:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponseDto toLoginResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        Integer userId = null;
        String roleName = null;

        userId = user.getId();
        roleName = userRoleName( user );

        LoginResponseDto loginResponseDto = new LoginResponseDto( userId, roleName );

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

    private String userRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
