package hu.acsaifz.jwtdemo;

import hu.acsaifz.jwtdemo.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class SpringSecurityJwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
    }

}
