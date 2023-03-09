package com.project.projectcomm.service;

import com.project.projectcomm.dto.NoticeDto;
import com.project.projectcomm.mapper.NoticeMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImp implements NoticeService {
    private NoticeMapper noticeMapper;
    private UserMapper userMapper;

    public NoticeServiceImp(NoticeMapper noticeMapper, UserMapper userMapper) {
        this.noticeMapper = noticeMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(NoticeDto notice) {
        return noticeMapper.insertOne(notice);
    }

    @Override
    public int modifyStatus(int noticeId, boolean status) {
        return noticeMapper.updateStatus(noticeId, status);
    }

    @Override
    public int removeOne(int noticeId) {
        return noticeMapper.deleteByNoticeId(noticeId);
    }

    @Override
    public int removeAll(int userId) {
        return noticeMapper.deleteByUserId(userId);
    }

    @Override
    public int countNotice(int userId) {
        return noticeMapper.countByUserId(userId);
    }

    @Override
    public NoticeDto findNotice(int noticeId) {
        return noticeMapper.selectByNoticeId(noticeId);
    }

    @Override
    public List<NoticeDto> noticeList(int userId) {
        return noticeMapper.listByUserId(userId);
    }
}
