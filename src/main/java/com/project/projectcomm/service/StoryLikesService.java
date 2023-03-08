package com.project.projectcomm.service;

import com.project.projectcomm.dto.StoryLikesDto;
import com.project.projectcomm.dto.UserDto;

import java.util.List;

public interface StoryLikesService {
    int register(StoryLikesDto storyLikes);
    int removeOne(int slikesId);
    int removeAll(int userId);
    int countStoryLikes(int storyId);
    StoryLikesDto findStoryLikes(UserDto loginUser, int storyId);
    List<StoryLikesDto> storyLikesList(int userId);
}
