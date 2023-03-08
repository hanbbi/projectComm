package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.CateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CateMapper {
    int insertOne(CateDto cate);  // 카테고리 등록
    CateDto findByCateId(int id);  // 해당 카테고리 찾기
    List<CateDto> listAll();  // 카테고리 목록
}
