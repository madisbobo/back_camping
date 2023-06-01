package ee.camping.back_camping.business.users;

import ee.camping.back_camping.business.dto.ContactDto;
import ee.camping.back_camping.business.dto.LoginResponseDto;
import ee.camping.back_camping.business.dto.NewUserDto;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserMapper;
import ee.camping.back_camping.domain.user.UserService;
import ee.camping.back_camping.domain.user.contact.Contact;
import ee.camping.back_camping.domain.user.contact.ContactMapper;
import ee.camping.back_camping.domain.user.contact.ContactService;
import ee.camping.back_camping.domain.user.role.Role;
import ee.camping.back_camping.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    public static final int ROLE_ID_CUSTOMER = 2;
    @Resource
    private UserService userService;

    @Resource
    private ContactService contactService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;


    @Transactional
    public LoginResponseDto addUser(NewUserDto newUserDto) {
        // Kontrolli kas selline kasutajanimi on juba olemas. Kui on, siis throw error
        userService.validateIfUsernameIsAvailable(newUserDto.getUsername());
        User user = userMapper.toUser(newUserDto);
        Role role = roleService.findRoleBy(ROLE_ID_CUSTOMER);
        user.setRole(role);

        userService.addUser(user);
        Contact contact = createBlankContact(user);
        contactService.addContact(contact);

        // Mappime olemasoleva user entity ümber loginResponseDto-ks, et tagastada UserId ja RoleName
        return userMapper.toLoginResponseDto(user, false);

    }


    public void deleteUser(Integer userId) {
        userService.deleteUserBy(userId);
    }

    public ContactDto getContact(Integer userId) {
        Contact contact = contactService.getUserContactBy(userId);
        return contactMapper.toContactDto(contact);

    }

    public void editContact(ContactDto contactDto) {
        Contact contact = contactService.getUserContactBy(contactDto.getUserId());
        contactMapper.partialUpdate(contactDto, contact);
        User user = userService.findUserBy(contactDto.getUserId());
        contact.setUser(user);
        contactService.addContact(contact);
    }

    private static Contact createBlankContact(User user) {
        Contact contact = new Contact();
        contact.setUser(user);
        contact.setFirstName("");
        contact.setLastName("");
        contact.setEmail("");
        return contact;
    }
}
