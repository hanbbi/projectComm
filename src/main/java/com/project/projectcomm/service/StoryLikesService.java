package com.project.projectcomm.service;

import com.project.projectcomm.dto.StoryLikesDto;

import java.util.List;

public interface StoryLikesService {
    int register(StoryLikesDto storyLikes);
    int removeOne(int slikesId);
    int removeAll(int userId);
    int countStoryLikes(int storyId);
    StoryLikesDto findStoryLikes(int userId, int storyId);
    List<StoryLikesDto> storyLikesList(int userId);
}
