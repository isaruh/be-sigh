package com.isaruh.sigh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // define controller
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
}
