package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.CommLikesDto;
import com.project.projectcomm.dto.CommLikesViewDto;
import com.project.projectcomm.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface CommLikesService {
    int register(CommLikesDto commLikes);

    int remove(int clikesId);

    int modify(CommLikesDto commLikes);

    CommLikesDto find(int commId, int loginUserId);
    CommLikesViewDto findCommLikes(int commId, int loginUserId);

    List<CommLikesDto> commLikesList(int userId);
}
