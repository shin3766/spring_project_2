package com.sparta.springproject2.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TodoRequestDto {
    private String username;
    private String todoTitle;
    private String todoContents;
}
