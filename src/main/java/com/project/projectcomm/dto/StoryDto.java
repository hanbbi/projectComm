package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StoryDto {
    private int storyId;  // PK
    private int userId;  // FK
    private String content;
    private boolean storyStatus;  // 0:읽음, 1:안읽음(default)
    private Date regDate;  // default CURRENT_TIMESTAMP
    private UserDto user;
    // 스토리 쌓이게 어떻게 하지?
}
