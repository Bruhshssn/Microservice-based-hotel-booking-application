package com.airbnb.auth.service;

import com.airbnb.auth.entity.User;
import com.airbnb.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtService jwtService;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(rawPassword));
        userRepository.save(user);
    }

    public String verifyUser(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getEmail());
        }
        return "Failed to authenticate";
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
