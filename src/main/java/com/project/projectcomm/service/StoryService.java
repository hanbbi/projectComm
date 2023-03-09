package com.project.projectcomm.service;

import com.project.projectcomm.dto.StoryDto;

import java.util.List;

public interface StoryService {
    int register(StoryDto story);
    int modifyStatus(int storyId, boolean status);
    int removeOne(int storyId);
    int removeAll(int userId);
    int countStory(int userId);
    StoryDto findStory(int storyId);
    List<StoryDto> storyList(int userId);
}
