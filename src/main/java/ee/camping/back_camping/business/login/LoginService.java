package ee.camping.back_camping.business.login;

import ee.camping.back_camping.business.dto.LoginResponseDto;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserMapper;
import ee.camping.back_camping.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponseDto login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        return userMapper.toLoginResponseDto(user);

    }

}
