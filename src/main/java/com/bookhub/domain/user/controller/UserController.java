package com.bookhub.domain.user.controller;

import com.bookhub.domain.user.dto.UserResponseDto;
import com.bookhub.domain.user.dto.UserSignUpRequestDto;
import com.bookhub.domain.user.dto.UserSignUpResponseDto;
import com.bookhub.domain.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserSignUpResponseDto> signUp(
        @RequestBody UserSignUpRequestDto requestDto) {
        return ResponseEntity.ok(userService.signUp(requestDto));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
