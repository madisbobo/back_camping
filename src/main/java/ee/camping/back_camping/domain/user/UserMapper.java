package ee.camping.back_camping.domain.user;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.dto.LoginResponseDto;
import ee.camping.back_camping.business.dto.NewUserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(expression = "java(user.getId())", target = "userId")
    @Mapping(expression = "java(user.getRole().getName())", target = "roleName")
    @Mapping(expression = "java(profileIsCompleted)", target = "profileIsCompleted")
    LoginResponseDto toLoginResponseDto(User user, Boolean profileIsCompleted);



    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    User toUser(NewUserDto newUserDto);


}