package hu.acsaifz.jwtdemo.service;

import hu.acsaifz.jwtdemo.model.Role;
import hu.acsaifz.jwtdemo.model.User;
import hu.acsaifz.jwtdemo.repository.RoleRepository;
import hu.acsaifz.jwtdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User saveUser(User user){
        log.info("Saving new user to the database");
        return userRepository.save(user);
    }

    public Role saveRole(Role role){
        log.info("Saving new role to the database");
        return roleRepository.save(role);
    }

    public User getUser(String username){
        log.info("Fetching user");
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUser(){
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public Role getRole(String name){
        log.info("Fetching role");
        return roleRepository.findByName(name);
    }

    public List<Role> getRoles(){
        log.info("Fetching all roles");
        return roleRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUser(username);

        if (user == null){
            log.error("User not found in the database: {}", username);
            throw new UsernameNotFoundException(username);
        }

        log.info("User logged in");
        return user;
    }
}
