package codegym.service;


import codegym.models.Role;
import codegym.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    Page<Users> findAll(Pageable pageable);
    Iterable<Users> findAll();
    Users findOne(Long id);

    Users save (Users user);

    Users delete(Long id);

    Page<Users> findAllByRoleEquals(Role role, Pageable pageable);

    Users findUsersByUserName(String username);
}
