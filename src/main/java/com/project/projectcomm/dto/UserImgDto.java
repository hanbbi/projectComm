package com.project.projectcomm.dto;

import lombok.Data;

@Data
public class UserImgDto {
    private int userImgId;  // PK
    private int userId;  // FK
    private String imgPath;
}
