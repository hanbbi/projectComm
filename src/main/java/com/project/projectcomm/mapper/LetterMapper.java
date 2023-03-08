package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.LetterDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LetterMapper {
    int insertOne(LetterDto letter);  // 쪽지 작성
    int updateStatus(int id, int status);  // 쪽지 상태 수정
    int deleteByLetterId(int id);  // 쪽지 선택 삭제
    int deleteByUserId(int id);  // 해당 사용자의 쪽지 전체 삭제
    int countByUserId(int id);  // 해당 사용자의 쪽지 수
    LetterDto selectByUserIdAndSenderId(int userId, int senderId);  // 해당 사용자의 해당 사용자로부터 온 쪽지 찾기
    List<LetterDto> listByUserId(int id);  // 해당 사용자의 쪽지 목록
}
