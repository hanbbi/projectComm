package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserReportDto {
    private int ureportId;  // PK
    private int userId;  // FK
    private int targetId;  // FK
    private String title;
    private String content;  // NULL
    private boolean reportStatus;  // 0:처리 후, 1:처리 전(default)
    private Date regDate;  // default CURRENT_TIMESTAMP
    private List<UserDto> userList;
}
