package com.project.projectcomm.service;

import com.project.projectcomm.dto.CateConnDto;
import com.project.projectcomm.mapper.CateConnMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateConnServiceImp implements CateConnService {
    private CateConnMapper cateConnMapper;

    public CateConnServiceImp(CateConnMapper cateConnMapper) {
        this.cateConnMapper = cateConnMapper;
    }

    @Override
    public int register(CateConnDto cateConn) {
        return cateConnMapper.insertOne(cateConn);
    }

    @Override
    public int removeOne(int commId) {
        return cateConnMapper.deleteByCommId(commId);
    }

    @Override
    public List<CateConnDto> cateConnList(String cateId) {
        return cateConnMapper.listByCateId(cateId);
    }
}
