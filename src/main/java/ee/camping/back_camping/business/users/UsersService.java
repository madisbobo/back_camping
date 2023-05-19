package ee.camping.back_camping.business.users;

import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserMapper;
import ee.camping.back_camping.domain.user.UserService;
import ee.camping.back_camping.domain.user.role.Role;
import ee.camping.back_camping.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    public static final int ROLE_ID_CUSTOMER = 2;
    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserMapper userMapper;



    public void addUser(NewUserDto newUserDto) {
        // Kontrolli kas selline kasutajanimi on juba olemas. Kui on, siis throw error
        userService.validateIfUsernameIsAvailable(newUserDto.getUsername());
        User user = userMapper.toUser(newUserDto);
        Role role = roleService.findRoleBy(ROLE_ID_CUSTOMER);
        user.setRole(role);

        userService.addUser(user);
    }
}
