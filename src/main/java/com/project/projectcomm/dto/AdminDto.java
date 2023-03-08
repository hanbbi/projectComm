package com.project.projectcomm.dto;

import lombok.Data;

@Data
public class AdminDto {
    private int adminId;  // PK
    private String adminName;
    private String adminEmail;
    private String adminPw;
    private String adminNick;
}
