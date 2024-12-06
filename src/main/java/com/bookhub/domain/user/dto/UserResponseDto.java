package com.bookhub.domain.user.dto;

import com.bookhub.domain.user.vo.UserVo;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private Long userId;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public UserResponseDto(UserVo user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
