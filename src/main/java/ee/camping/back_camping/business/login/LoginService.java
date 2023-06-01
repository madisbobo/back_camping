package ee.camping.back_camping.business.login;

import ee.camping.back_camping.business.dto.LoginResponseDto;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserMapper;
import ee.camping.back_camping.domain.user.UserService;
import ee.camping.back_camping.domain.user.contact.Contact;
import ee.camping.back_camping.domain.user.contact.ContactService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private ContactService contactService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private LoginResponseDto loginResponseDto;

    public LoginResponseDto login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);

        Contact contact = contactService.getUserContactBy(user.getId());
        boolean profileIsCompleted = true;
        if (contact.getFirstName().equals("") || contact.getLastName().equals("") || contact.getEmail().equals("")) {
            profileIsCompleted = false;
        }



        return userMapper.toLoginResponseDto(user, profileIsCompleted);

    }

}
