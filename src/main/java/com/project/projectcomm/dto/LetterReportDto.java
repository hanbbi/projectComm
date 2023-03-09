package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LetterReportDto {
    private int lreportId;  // PK
    private int userId;  // FK
    private int letterId;  // FK
    private String title;
    private String content;  // NULL
    private boolean reportStatus;  // 0:처리 후, 1:처리 전(default)
    private Date regDate;  // default CURRENT_TIMESTAMP
    private LetterDto letter;
}
