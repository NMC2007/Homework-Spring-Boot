package com.example.session14.service;

import com.example.session14.model.dto.request.UserCreateDTO;
import com.example.session14.model.dto.request.UserLoginDTO;
import com.example.session14.model.entity.Role;
import com.example.session14.model.entity.User;
import com.example.session14.principal.UserPrincipal;
import com.example.session14.repository.UserRepository;
import com.example.session14.validator.BadCredentialsExceptionCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

//    đăng ký
    public User createUser(UserCreateDTO req) {
        User newUser = new User();

        newUser.setUsername(req.getUsername());
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));
        newUser.setRole(Role.USER);

        return userRepository.save(newUser);
    }

//    đăng nhập
    public UserPrincipal loginByUserNameAndPassword (UserLoginDTO req) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getUsername(),
                            req.getPassword()
                    )
            );

//             nếu chạy được tới đây => login thành công
            return (UserPrincipal) authentication.getPrincipal();

        } catch (BadCredentialsException e) {
            throw new BadCredentialsExceptionCustom("username or password incorrect");
        }
    }
}
