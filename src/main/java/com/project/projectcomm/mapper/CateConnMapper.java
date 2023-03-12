package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.CateConnDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CateConnMapper {
    int insertOne(CateConnDto cateConn);  // 카테고리 연결 등록
    int deleteByCommId(int id);  // 카테고리 연결 해제
    List<CateConnDto> listByCateId(String id);  // 해당 카테고리와 연결된 카테고리 연결 목록
    List<CateConnDto> listByCommId(int id);
    CateConnDto selectByCommId(int id);
}
