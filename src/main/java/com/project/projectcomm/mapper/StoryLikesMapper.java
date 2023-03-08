package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.StoryLikesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoryLikesMapper {
    int insertOne(StoryLikesDto storyLikes);  // 스토리 좋아요 등록
    int deleteBySlikesId(int id);  // 스토리 좋아요 취소
    int deleteByUserId(int id);  // 해당 사용자의 모든 스토리 좋아요 취소
    int countByStoryId(int id);  // 해당 스토리의 좋아요 수
    StoryLikesDto selectByUserIdAndStoryId(int userId, int storyId);  // 해당 사용자가 해당 스토리에 좋아요 눌렀는지 여부
    List<StoryLikesDto> listByUserId(int id);  // 해당 사용자의 스토리 좋아요 목록
}
