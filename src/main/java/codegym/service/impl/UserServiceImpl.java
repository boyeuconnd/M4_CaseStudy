package codegym.service.impl;

import codegym.models.Role;
import codegym.models.Users;
import codegym.repositories.UserRepository;
import codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users delete(Long id) {
        Users users = userRepository.findOne(id);
        userRepository.delete(id);
        return users;
    }

    @Override
    public Page<Users> findAllByRoleEquals(Role role, Pageable pageable) {
        return userRepository.findAllByRoleEquals(role,pageable);
    }
}
