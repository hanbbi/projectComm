package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommLikesDto;

import java.util.List;

public interface CommLikesService {
    int register(CommLikesDto commLikes);
    int removeOne(int clikesId);
    int removeAll(int userId);
    int countCommLikes(int commId);
    CommLikesDto findCommLikes(int userId, int commId);
    List<CommLikesDto> commLikesList(int userId);
}
