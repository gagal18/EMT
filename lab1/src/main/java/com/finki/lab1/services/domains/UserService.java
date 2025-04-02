package com.finki.lab1.services.domains;

import com.finki.lab1.model.domains.User.User;
import com.finki.lab1.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
}

