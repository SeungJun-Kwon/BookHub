package com.bookhub.domain.user.service;

import com.bookhub.domain.user.dto.UserResponseDto;
import com.bookhub.domain.user.dto.UserSignUpRequestDto;
import com.bookhub.domain.user.dto.UserSignUpResponseDto;
import com.bookhub.domain.user.repository.UserRepository;
import com.bookhub.domain.user.vo.UserVo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignUpResponseDto signUp(UserSignUpRequestDto requestDto) {
        UserVo userVo = userRepository.signUp(requestDto);

        return new UserSignUpResponseDto(userVo);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.getAllUsers().stream().map(UserResponseDto::new).toList();
    }
}
