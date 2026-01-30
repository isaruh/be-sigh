package com.isaruh.sigh.service;

import com.isaruh.sigh.entity.User;
import com.isaruh.sigh.model.request.UserRequest;
import com.isaruh.sigh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // define service
@RequiredArgsConstructor // generate constructor for all final fields
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public User create(UserRequest userRequest) {
        isUsernameExists(userRequest);
        isEmailExists(userRequest);

        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .name(userRequest.getName())
                .build();

        return userRepository.saveAndFlush(user);
    }

    private void isUsernameExists(UserRequest userRequest) {
        if (userRequest.getId() != null) {
            if (userRepository.existsByUsernameAndIdNot(userRequest.getUsername(), userRequest.getId())) {
                throw new RuntimeException("Username already exist: " + userRequest.getUsername());
            }
        } else {
            if (userRepository.existsByUsername(userRequest.getUsername())) {
                throw new RuntimeException("Username already exist: " + userRequest.getUsername());
            }
        }
    }

    private void isEmailExists(UserRequest userRequest) {
        if (userRequest.getId() != null) {
            if (userRepository.existsByEmailAndIdNot(userRequest.getEmail(), userRequest.getId())) {
                throw new RuntimeException("Email already exist: " + userRequest.getEmail());
            }
        } else {
            if (userRepository.existsByEmail(userRequest.getEmail())) {
                throw new RuntimeException("Email already exist: " + userRequest.getEmail());
            }
        }
    }
}
