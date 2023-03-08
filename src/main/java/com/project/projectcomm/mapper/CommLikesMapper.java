package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.CommLikesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommLikesMapper {
    int insertOne(CommLikesDto commLikes);  // 커뮤니티 글 좋아요 등록
    int deleteByClikesId(int id);  // 커뮤니티 글 좋아요 취소
    int deleteByUserId(int id);  // 해당 사용자 모든 커뮤니티 글 좋아요 취소
    int countByCommId(int id);  // 해당 커뮤니티 글 좋아요 수
    CommLikesDto selectByUserIdAndCommId(int userId, int commId);  // 사용자가 해당 커뮤니티 글에 좋아요 했는지 여부
    List<CommLikesDto> listByUserId(int id);  // 사용자가 커뮤니티 글 좋아요 목록
}
