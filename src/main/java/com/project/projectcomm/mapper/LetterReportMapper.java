package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.LetterReportDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LetterReportMapper {
    int insertOne(LetterReportDto letterReport);  // 쪽지 신고 등록
    int updateStatus(int id, boolean status);  // 쪽지 신고 등록 상태 수정
    LetterReportDto selectByLreportId(int id);  // 해당 쪽지 신고 찾기
    List<LetterReportDto> listByUserId(int id);  // 해당 사용자의 쪽지 신고 목록
    List<LetterReportDto> listAll();  // 쪽지 신고 전체 목록
}
