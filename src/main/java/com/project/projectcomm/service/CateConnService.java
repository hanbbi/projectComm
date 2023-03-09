package com.project.projectcomm.service;

import com.project.projectcomm.dto.CateConnDto;

import java.util.List;

public interface CateConnService {
    int register(CateConnDto cateConn);
    int removeOne(int commId);
    List<CateConnDto> cateConnList(String cateId);
}
