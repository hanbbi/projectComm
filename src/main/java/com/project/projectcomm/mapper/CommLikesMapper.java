package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.CommLikesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommLikesMapper {
    int insertOne(CommLikesDto commLikes);  // 커뮤니티 글 좋아요 등록
    int update(CommLikesDto commLikes);
    int deleteByClikesId(int id);  // 커뮤니티 글 좋아요 취소
    CommLikesDto selectByCommIdAndUserId(int commId, int userId);  // 사용자가 해당 커뮤니티 글에 좋아요 했는지 여부
    List<CommLikesDto> listByUserId(int id);  // 사용자가 커뮤니티 글 좋아요 목록
    int countByCommIdAndLikesIsTrue(int commId);
    int countByCommIdAndLikesIsFalse(int commId);
}
