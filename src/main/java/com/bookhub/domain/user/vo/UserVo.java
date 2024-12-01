package com.bookhub.domain.user.vo;

import lombok.Getter;

@Getter
public class UserVo {

    private final Long userId;
    private final String userName;

    public UserVo(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
