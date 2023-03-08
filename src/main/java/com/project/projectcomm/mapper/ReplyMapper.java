package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.ReplyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int insertOne(ReplyDto reply);  // 댓글 작성
    int updateOne(ReplyDto reply);  // 댓글 수정
    int updateStatus(int id, boolean status);  // 댓글 상태 수정
    int deleteByReplyId(int id);  // 댓글 선택 삭제
    int deleteByUserId(int id);  // 해당 사용자가 작성한 댓글 전체 삭제
    int countByCommId(int id);  // 해당 커뮤니티 글의 댓글 수
    int countByUserId(int id);  // 해당 사용자가 작성한 댓글 수
    ReplyDto selectByReplyId(int id);  // 해당 댓글 찾기
    List<ReplyDto> listByCommId(int id);  // 해당 커뮤니티 글의 댓글 목록
    List<ReplyDto> listByUserId(int id);  // 해당 사용자가 작성한 댓글 목록
}
