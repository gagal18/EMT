package com.finki.lab1.services.application;
import com.finki.lab1.dto.CreateUserDto;
import com.finki.lab1.dto.DisplayUserDto;
import com.finki.lab1.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
