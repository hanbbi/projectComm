package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.FriendDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendMapper {
    int insertOne(FriendDto friend);  // 팔로우 등록
    int deleteByFollowId(int id);  // 팔로우 취소
    int deleteByUserId(int id);  // 해당 사용자의 전체 팔로우 취소
    int countByUserId(int id);  // 해당 사용자의 팔로잉 수
    int countByFollowId(int id);  // 해당 사용자의 팔로워 수
    FriendDto selectByUserIdAndFollowId(int userId, int followId);  // 해당 사용자가 해당 사용자를 팔로우하는지 여부
    List<FriendDto> listByUserId(int id);  // 해당 사용자의 팔로잉 목록
    List<FriendDto> listByFollowId(int id);  // 해당 사용자의 팔로워 목록
}
