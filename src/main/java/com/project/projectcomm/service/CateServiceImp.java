package com.project.projectcomm.service;

import com.project.projectcomm.dto.CateDto;
import com.project.projectcomm.mapper.CateMapper;
import org.springframework.stereotype.Service;

@Service
public class CateServiceImp implements CateService {
    private CateMapper cateMapper;

    public CateServiceImp(CateMapper cateMapper) {
        this.cateMapper = cateMapper;
    }

    @Override
    public int register(CateDto cate) {
        return cateMapper.insertOne(cate);
    }

    @Override
    public CateDto selectCate(int cateId) {
        return cateMapper.findByCateId(cateId);
    }
}
