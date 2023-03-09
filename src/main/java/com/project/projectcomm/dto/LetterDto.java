package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LetterDto {
    private int letterId;  // PK
    private int userId;  // FK
    private int senderId;  // FK
    private String content;
    private int letterStatus;  // 0:읽음, 1:안읽음(default), 2:정지
    private Date regDate;  // default CURRENT_TIMESTAMP
    private Date delDate;  // default CURRENT_TIMESTAMP
    private UserDto user;
}
