package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommReportDto {
    private int creportId;  // PK
    private int userId;  // FK
    private int commId;  // FK
    private String title;
    private String content;  // NULL
    private boolean reportStatus;  // 0:처리 후, 1:처리 전(default)
    private Date regDate;  // default CURRENT_TIMESTAMP
    private CommDto comm;
}
