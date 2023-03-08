package com.project.projectcomm.service;

import com.project.projectcomm.dto.StoryLikesDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.mapper.StoryLikesMapper;
import com.project.projectcomm.mapper.StoryMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryLikesServiceImp implements StoryLikesService {
    StoryLikesMapper storyLikesMapper;
    StoryMapper storyMapper;
    UserMapper userMapper;

    public StoryLikesServiceImp(StoryLikesMapper storyLikesMapper, StoryMapper storyMapper, UserMapper userMapper) {
        this.storyLikesMapper = storyLikesMapper;
        this.storyMapper = storyMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(StoryLikesDto storyLikes) {
        StoryLikesDto storyLikesDto = storyLikesMapper.selectByUserIdAndStoryId(storyLikes.getUserId(), storyLikes.getStoryId());
        if (storyLikesDto != null) return 0;
        return storyLikesMapper.insertOne(storyLikes);
    }

    @Override
    public int removeOne(int slikesId) {
        return storyLikesMapper.deleteBySlikesId(slikesId);
    }

    @Override
    public int removeAll(int userId) {
        return storyLikesMapper.deleteByUserId(userId);
    }

    @Override
    public int countStoryLikes(int storyId) {
        return storyLikesMapper.countByStoryId(storyId);
    }

    @Override
    public StoryLikesDto findStoryLikes(UserDto loginUser, int storyId) {
        return storyLikesMapper.selectByUserIdAndStoryId(loginUser.getUserId(), storyId);
    }

    @Override
    public List<StoryLikesDto> storyLikesList(int userId) {
        return storyLikesMapper.listByUserId(userId);
    }
}
