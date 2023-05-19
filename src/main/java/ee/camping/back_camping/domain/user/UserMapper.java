package ee.camping.back_camping.domain.user;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.login.LoginResponseDto;
import ee.camping.back_camping.business.users.NewUserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponseDto toLoginResponseDto(User user);


    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    User toUser(NewUserDto newUserDto);


}