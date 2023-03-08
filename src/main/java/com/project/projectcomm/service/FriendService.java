package com.project.projectcomm.service;

import com.project.projectcomm.dto.FriendDto;

import java.util.List;

public interface FriendService {
    int register(FriendDto friend);
    int removeOne(int followId);
    int removeAll(int userId);
    int countFollowing(int userId);
    int countFollower(int followId);
    FriendDto findFriend(int userId, int followId);
    List<FriendDto> followingList(int userId);
    List<FriendDto> followerList(int followId);
}
