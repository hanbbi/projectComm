package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.FriendDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.mapper.FriendMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FriendServiceImp implements FriendService {
    private FriendMapper friendMapper;
    private UserMapper userMapper;

    public FriendServiceImp(FriendMapper friendMapper, UserMapper userMapper) {
        this.friendMapper = friendMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(FriendDto friend) {
        FriendDto friendDto = friendMapper.selectByUserIdAndFollowId(friend.getUserId(), friend.getFollowId());
        if (friendDto != null) return 0;
        return friendMapper.insertOne(friend);
    }

    @Override
    public int removeOne(int userId, int followId) {
        return friendMapper.deleteByFollowId(userId, followId);
    }

    @Override
    public int removeAll(int userId) {
        return friendMapper.deleteByUserId(userId);
    }

    @Override
    public int countFollowing(int userId) {
        return friendMapper.countByUserId(userId);
    }

    @Override
    public int countFollower(int followId) {
        return friendMapper.countByFollowId(followId);
    }

    @Override
    public FriendDto findFriend(UserDto loginUser, int followId) {
        return friendMapper.selectByUserIdAndFollowId(loginUser.getUserId(), followId);
    }

    @Override
    public List<FriendDto> followingList(int userId) {
        return friendMapper.listByUserId(userId);
    }

    @Override
    public List<FriendDto> followerList(int followId) {
        return friendMapper.listByFollowId(followId);
    }

    @Override
    public Map<String, FriendDto> friendCheck(List<CommDto> commList, UserDto loginUser) {
        Map<String, FriendDto> friendMap = new HashMap<>();
        for (CommDto c : commList) {
            FriendDto friend = friendMapper.selectByUserIdAndFollowId(loginUser.getUserId(), c.getUserId());
            friendMap.put(""+c.getCommId(), friend);
        }
        return friendMap;
    }
}
