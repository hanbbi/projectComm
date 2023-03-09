package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReplyDto {
    private int replyId;  // PK
    private int userId;  // FK
    private int commId;  // FK
    private int fkReplyId;  // FK self-join
    private String content;
    private boolean replyStatus;  // 0:기본(default), 1:정지
    private Date regDate;  // default CURRENT_TIMESTAMP
    private Date modDate;  // default CURRENT_TIMESTAMP
    private UserDto user;
    private List<ReplyDto> replyList;
    // fkReplyId(대댓글) 만들까?
}
