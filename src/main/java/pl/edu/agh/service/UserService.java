package pl.edu.agh.service;

import pl.edu.agh.entity.Users;
import pl.edu.agh.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Users findByEmail(String email);

    Users save(UserRegistrationDto registration);
}
