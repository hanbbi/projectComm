package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private int userId;  // PK
    private String userName;
    private String userEmail;
    private String userPw;
    private String userPhone;
    private String userNick;
    private String userInfo;  // NULL
    private int userStatus;  // 0:기본(default), 1:정지, 2:탈퇴
    private Date regDate;  // default CURRENT_TIMESTAMP
    private Date modDate;  // default CURRENT_TIMESTAMP
    private String delReason;  // NULL
    private boolean letterOpen;  // 0:전체(default), 1:친구
    private boolean userOpen;  // 0:전체(default), 1:친구
    private String userImgId;  // FK
    private UserImgDto userImg;
}
