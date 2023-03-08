package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StoryLikesDto {
    private int slikesId;  // PK
    private int userId;  // FK
    private int storyId;  // FK
    private Date regDate;  // default CURRENT_TIMESTAMP
    private StoryDto story;
}
