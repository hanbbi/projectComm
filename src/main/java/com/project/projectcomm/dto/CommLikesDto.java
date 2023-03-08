package com.project.projectcomm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommLikesDto {
    private int clikesId;  // PK
    private int userId;  // FK
    private int commId;  // FK
    private Date regDate;  // default CURRENT_TIMESTAMP
    private CommDto comm;
}
