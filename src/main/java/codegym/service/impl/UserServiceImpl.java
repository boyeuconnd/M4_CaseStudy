package codegym.service.impl;

import codegym.models.Role;
import codegym.models.Users;
import codegym.repositories.UserRepository;
import codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService, UserDetailsService {
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

    @Override
    public Users findUsersByUserName(String username) {
        return userRepository.findUsersByUserName(username);
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.findUsersByUserName(username);
        List<GrantedAuthority> rolelist = new ArrayList<>();
        rolelist.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        return new User(user.getUserName(),user.getPassword(),rolelist);
    }
}
