package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.FriendDto;
import com.project.projectcomm.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface FriendService {
    int register(FriendDto friend);
    int removeOne(int userId, int followId);
    int removeAll(int userId);
    int countFollowing(int userId);
    int countFollower(int followId);
    FriendDto findFriend(UserDto loginUser, int followId);
    List<FriendDto> followingList(int userId);
    List<FriendDto> followerList(int followId);
    Map<String, FriendDto> friendCheck(List<CommDto> commList, UserDto loginUser);
}
