package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.CommLikesDto;
import com.project.projectcomm.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface CommLikesService {
    int register(CommLikesDto commLikes);
    int removeOne(int clikesId);
    int removeAll(int userId);
    int countCommLikes(int commId);
    CommLikesDto findCommLikes(UserDto loginUser, int commId);
    List<CommLikesDto> commLikesList(int userId);
    Map<String, CommLikesDto> likesCheck(List<CommDto> commList, UserDto loginUser);
}
