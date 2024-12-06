package com.bookhub.domain.user.vo;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class UserVo {

    private final Long userId;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UserVo(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        createdAt = null;
        modifiedAt = null;
    }

    public UserVo(Long userId, String userName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.userId = userId;
        this.userName = userName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
