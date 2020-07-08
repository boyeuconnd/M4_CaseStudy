package codegym.service;


import codegym.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    Page<Users> findAll(Pageable pageable);

    Users findOne(Long id);

    Users save (Users user);

    Users delete(Long id);
}
