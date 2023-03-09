package com.project.projectcomm.service;

import com.project.projectcomm.dto.StoryDto;
import com.project.projectcomm.mapper.StoryMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImp implements StoryService {
    private StoryMapper storyMapper;
    private UserMapper userMapper;

    public StoryServiceImp(StoryMapper storyMapper, UserMapper userMapper) {
        this.storyMapper = storyMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(StoryDto story) {
        return storyMapper.insertOne(story);
    }

    @Override
    public int modifyStatus(int storyId, boolean status) {
        return storyMapper.updateStatus(storyId, status);
    }

    @Override
    public int removeOne(int storyId) {
        return storyMapper.deleteByStoryId(storyId);
    }

    @Override
    public int removeAll(int userId) {
        return storyMapper.deleteByUserId(userId);
    }

    @Override
    public int countStory(int userId) {
        return storyMapper.countByUserId(userId);
    }

    @Override
    public StoryDto findStory(int storyId) {
        return storyMapper.selectByStoryId(storyId);
    }

    @Override
    public List<StoryDto> storyList(int userId) {
        return storyMapper.listByUserId(userId);
    }
}
