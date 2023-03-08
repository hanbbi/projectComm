package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommImgDto;

import java.util.List;

public interface CommImgService {
    int register(CommImgDto commImg);
    int removeOne(int commImgId);
    int removeOneAt(int commImgId, int seq);
    CommImgDto findCommImgAt(int commImgId, int seq);
    List<CommImgDto> commImgList(int commImgId);
}
