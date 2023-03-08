package com.project.projectcomm.dto;

import lombok.Data;

@Data
public class CommImgDto {
    private int commImgId;  // PK
    private int seq;  // PK
    private int commId;  // FK
    private String imgPath;
}
