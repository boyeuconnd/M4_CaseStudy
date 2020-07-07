package codegym.service.impl;

import codegym.models.Role;
import codegym.repositories.RoleRepository;
import codegym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;


    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findOne(id);
    }
}
