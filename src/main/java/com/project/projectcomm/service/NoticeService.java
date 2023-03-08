package com.project.projectcomm.service;

import com.project.projectcomm.dto.NoticeDto;

import java.util.List;

public interface NoticeService {
    int register(NoticeDto notice);
    int modifyStatus(int noticeId, boolean status);
    int removeOne(int noticeId);
    int removeAll(int userId);
    NoticeDto findNotice(int noticeId);
    List<NoticeDto> noticeList(int userId);
}
