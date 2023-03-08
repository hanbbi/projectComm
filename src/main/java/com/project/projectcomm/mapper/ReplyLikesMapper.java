package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.ReplyLikesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyLikesMapper {
    int insertOne(ReplyLikesDto replyLikes);  // 댓글 좋아요 등록
    int deleteByRlikesId(int id);  // 댓글 좋아요 취소
    int deleteByUserId(int id);  // 해당 사용자의 모든 댓글 좋아요 취소
    int countByReplyId(int id);  // 해당 댓글의 좋아요 수
    ReplyLikesDto selectByUserIdAndReplyId(int userId, int replyId);  // 해당 사용자가 해당 댓글에 좋아요 했는지 여부
    List<ReplyLikesDto> listByUserId(int id);  // 해당 사용자의 댓글 좋아요 목록
}
