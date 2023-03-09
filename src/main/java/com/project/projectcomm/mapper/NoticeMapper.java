package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int insertOne(NoticeDto notice);  // 알림 등록
    int updateStatus(int id, boolean status);  // 알림 상태 변경
    int deleteByNoticeId(int id);  // 알림 선택 삭제
    int deleteByUserId(int id);  // 해당 사용자의 알림 전체 삭제
    int countByUserId(int id);
    NoticeDto selectByNoticeId(int id);  // 해당 알림 찾기
    List<NoticeDto> listByUserId(int id);  // 해당 사용자의 알림 목록
}
