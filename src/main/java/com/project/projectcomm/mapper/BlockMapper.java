package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.BlockDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlockMapper {
    int insertOne(BlockDto block);  // 차단 등록
    int deleteByTargetId(int id);  // 선택 차단 해제
    int deleteByUserId(int id);  // 전체 차단 해제
    int countByUserId(int id);  // 사용자가 차단한 사용자 수
    BlockDto selectByUserIdAndTargetId(int userId, int targetId);  // 사용자가 해당 사용자를 차단했는지 여부
    List<BlockDto> listByUserId(int id);  // 사용자가 차단한 사용자 목록
}
