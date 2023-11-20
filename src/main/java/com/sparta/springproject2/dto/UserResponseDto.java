package com.sparta.springproject2.dto;

import lombok.Getter;
import com.sparta.springproject2.entity.User;

@Getter
public class UserResponseDto {
    private Long userId;
    private String username;
    private String name;

    public UserResponseDto(User user) {
        this.userId = getUserId();
        this.username = getUsername();
        this.name = getName();
    }
}
