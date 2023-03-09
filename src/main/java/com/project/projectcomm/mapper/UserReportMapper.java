package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.UserReportDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserReportMapper {
    int insertOne(UserReportDto userReport);  // 사용자 신고 등록
    int updateStatus(int id, boolean status);  // 사용자 신고 상태 수정
    UserReportDto selectByUreportId(int id);  // 해당 사용자 신고 찾기
    List<UserReportDto> listByUserId(int id);  // 해당 사용자의 사용자 신고 목록
    List<UserReportDto> listByTargetId(int id);
    List<UserReportDto> listAll();  // 사용자 신고 전체 목록
}
