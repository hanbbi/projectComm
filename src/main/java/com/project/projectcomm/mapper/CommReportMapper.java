package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.CommReportDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommReportMapper {
    int insertOne(CommReportDto commReport);  // 커뮤니티 글 신고 등록
    int updateStatus(int id, boolean status);  // 커뮤니티 글 신고 상태 수정
    CommReportDto selectByCreportId(int id);  // 해당 커뮤니티 글 신고 찾기
    List<CommReportDto> listByUserId(int id);  // 해당 사용자의 커뮤니티 글 신고 목록
    List<CommReportDto> listAll();  // 커뮤니티 글 신고 전체 목록
}
