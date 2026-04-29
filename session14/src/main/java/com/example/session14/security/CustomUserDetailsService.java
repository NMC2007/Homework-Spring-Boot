package com.example.session14.security;

import com.example.session14.model.dto.request.UserCreateDTO;
import com.example.session14.model.entity.Role;
import com.example.session14.model.entity.User;
import com.example.session14.principal.UserPrincipal;
import com.example.session14.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return new UserPrincipal(user);
    }

    public User createUser(UserCreateDTO req) {
        User newUser = new User();

        newUser.setUsername(req.getUsername());
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));
        newUser.setRole(Role.USER);

        return userRepository.save(newUser);
    }
}
