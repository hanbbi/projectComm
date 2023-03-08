package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.ReplyReportDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyReportMapper {
    int insertOne(ReplyReportDto replyReport);  // 댓글 신고 등록
    int updateStatus(int id, boolean status);  // 댓글 신고 상태 수정
    ReplyReportDto selectByRreportId(int id);  // 해당 댓글 신고 찾기
    List<ReplyReportDto> listByUserId(int id);  // 해당 사용자의 댓글 신고 목록
    List<ReplyReportDto> listAll();  // 댓글 신고 전체 목록
}
