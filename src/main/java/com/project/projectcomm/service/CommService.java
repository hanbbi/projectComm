package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;

import java.util.List;

public interface CommService {
    int register(CommDto comm);
    int modifyOne(CommDto comm);
    int modifyOpen(int commId, boolean openStatus);
    int modifyStatus(int commId, boolean commStatus);
    int modifyViews(int commId);
    int removeOne(int commId);
    int removeAll(int userId);
    CommDto findComm(int commId);
    List<CommDto> commList(int userId);
}
