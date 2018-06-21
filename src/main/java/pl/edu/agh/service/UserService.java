package pl.edu.agh.service;

import pl.edu.agh.entity.User;
import pl.edu.agh.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
