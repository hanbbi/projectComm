package com.project.projectcomm.service;

import com.project.projectcomm.dto.CateDto;
import com.project.projectcomm.mapper.CateMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CateDto selectCate(String cateId) {
        return cateMapper.selectByCateId(cateId);
    }

    @Override
    public List<CateDto> listAll() {
        return cateMapper.listAll();
    }
}
