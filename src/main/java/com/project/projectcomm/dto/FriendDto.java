package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FriendDto {
    private int friendId;  // PK
    private int userId;  // FK
    private int followId;  // FK
    private Date regDate;  // default CURRENT_TIMESTAMP
}
