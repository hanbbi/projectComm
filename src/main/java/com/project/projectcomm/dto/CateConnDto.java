package com.project.projectcomm.dto;

import lombok.Data;

@Data
public class CateConnDto {
    private int cateConnId;  // PK
    private int cateId;  // FK
    private int commId;  // FK
    private CateDto cate;
    private CommDto comm;
    // cateId, commId 를 PK&FK 로 두고 하면?
}
