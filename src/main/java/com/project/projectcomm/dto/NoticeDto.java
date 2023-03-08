package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeDto {
    private int noticeId;
    private int userId;
    private String content;
    private boolean noticeStatus;  // 0:읽음, 1:안읽음(default)
    private Date regDate;  // default CURRENT_TIMESTAMP
    // 알림 눌렀을 때 해당 알림 상세 페이지로 어떻게 넘기지?
}
