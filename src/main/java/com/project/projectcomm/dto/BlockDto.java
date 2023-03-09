package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BlockDto {
    private int blockId;  // PK
    private int userId;  // FK
    private int targetId;  // FK
    private Date regDate;  // default CURRENT_TIMESTAMP
    private UserDto user;
}
