package com.isaruh.sigh.controller;

import com.isaruh.sigh.entity.User;
import com.isaruh.sigh.model.request.UserRequest;
import com.isaruh.sigh.service.UserService;
import com.isaruh.sigh.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // define controller
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerHandler(@RequestBody UserRequest userRequest) {
        User user = userService.create(userRequest);
        return ResponseUtil.buildSingleResponse(
                HttpStatus.CREATED,
                "User created",
                user.toResponse()
        );
    }
}
