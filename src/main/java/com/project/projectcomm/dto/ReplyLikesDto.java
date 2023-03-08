package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyLikesDto {
    private int rlikesId;  // PK
    private int userId;  // FK
    private int replyId;  // FK
    private Date regDate;  // default CURRENT_TIMESTAMP
    private ReplyDto reply;
    // commId FK 로 참조해야할까?
}
