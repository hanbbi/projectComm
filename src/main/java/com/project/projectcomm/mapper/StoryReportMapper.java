package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.StoryReportDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoryReportMapper {
    int insertOne(StoryReportDto storyReport);  // 스토리 신고 등록
    int updateStatus(int id, boolean status);  // 스토리 신고 상태 변경
    StoryReportDto selectBySreportId(int id);  // 해당 스토리 신고 찾기
    List<StoryReportDto> listByUserId(int id);  // 해당 사용자의 스토리 신고 목록
    List<StoryReportDto> listAll();  // 스토리 신고 전체 목록
}
