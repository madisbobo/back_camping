package ee.camping.back_camping.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;


    public Role findRoleBy(int roleIdCustomer) {
       return roleRepository.findById(roleIdCustomer).get();
    }
}
