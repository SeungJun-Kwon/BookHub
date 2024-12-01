package com.bookhub.domain.user.repository;

import com.bookhub.domain.user.dto.UserSignUpRequestDto;
import com.bookhub.domain.user.vo.UserVo;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserVo signUp(UserSignUpRequestDto requestDto) {
        String query = "insert into user_tb (user_name, created_at, modified_at) value (?, ?, ?)";

        // Auto Increment 된 Key 반환을 위한 KeyHolder
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            LocalDateTime now = LocalDateTime.now();

            // DB 삽입 후 생성된 Key 값 요청
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, requestDto.getUserName());
            ps.setTimestamp(2, Timestamp.valueOf(now));
            ps.setTimestamp(3, Timestamp.valueOf(now));

            return ps;
        }, keyHolder);

        try {
            return new UserVo(keyHolder.getKey().longValue(), requestDto.getUserName());
        } catch (NullPointerException e) {
            throw new NullPointerException("Fail SignUp");
        }
    }
}
