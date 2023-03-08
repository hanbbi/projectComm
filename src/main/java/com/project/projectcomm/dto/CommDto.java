package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommDto {
    private int commId;  // PK
    private int userId;  // FK
    private String title;
    private String content;
    private boolean openStatus;  // 0:전체(default), 1:친구
    private boolean commStatus;  // 0:기본(default), 1:정지
    private int views;  // default 0
    private Date regDate;  // default CURRENT_TIMESTAMP
    private Date modDate;  // default CURRENT_TIMESTAMP
    private UserDto user;
    private String commImgId;
    private List<CommImgDto> imgList;
}
