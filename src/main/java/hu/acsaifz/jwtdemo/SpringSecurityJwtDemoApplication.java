package hu.acsaifz.jwtdemo;

import hu.acsaifz.jwtdemo.config.RsaKeyProperties;
import hu.acsaifz.jwtdemo.model.Role;
import hu.acsaifz.jwtdemo.model.User;
import hu.acsaifz.jwtdemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class SpringSecurityJwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, PasswordEncoder passwordEncoder){
        return args -> {
            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_ADMIN"));

            List<Role> roles = userService.getRoles();

            User user = new User("John Doe", "john", passwordEncoder.encode("password"));
            user.addRole(roles.get(0));

            User anotherUser = new User("Jack Doe", "jack", passwordEncoder.encode("anotherPassword"));
            anotherUser.addRole(roles.get(0));
            anotherUser.addRole(roles.get(1));

            userService.saveUser(user);
            userService.saveUser(anotherUser);

        };
    }
}
