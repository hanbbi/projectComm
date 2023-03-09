package com.project.projectcomm.service;

import com.project.projectcomm.dto.CateDto;

import java.util.List;

public interface CateService {
    int register(CateDto cate);
    CateDto selectCate(String cateId);
}
