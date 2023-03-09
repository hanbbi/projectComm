package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.StoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoryMapper {
    int insertOne(StoryDto story);  // 스토리 작성
    int updateStatus(int id, boolean status);  // 스토리 상태 수정
    int deleteByStoryId(int id);  // 스토리 선택 삭제
    int deleteByUserId(int id);  // 해당 사용자의 스토리 전체 삭제
    int countByUserId(int id);
    StoryDto selectByStoryId(int id);  // 해당 스토리 찾기
    List<StoryDto> listByUserId(int id);  // 해당 사용자의 스토리 목록
    List<StoryDto> listAll();  // 스토리 전체 목록
}
