package com.bookhub.domain.user.dto;

import com.bookhub.domain.user.vo.UserVo;
import lombok.Getter;

@Getter
public class UserSignUpResponseDto {

    private Long userId;
    private String userName;

    public UserSignUpResponseDto(UserVo userVo) {
        this.userId = userVo.getUserId();
        this.userName = userVo.getUserName();
    }
}
