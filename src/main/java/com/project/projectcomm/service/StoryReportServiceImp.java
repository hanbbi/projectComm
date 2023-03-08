package com.project.projectcomm.service;

import com.project.projectcomm.dto.StoryReportDto;
import com.project.projectcomm.mapper.StoryMapper;
import com.project.projectcomm.mapper.StoryReportMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryReportServiceImp implements StoryReportService {
    private StoryReportMapper storyReportMapper;
    private StoryMapper storyMapper;
    private UserMapper userMapper;

    public StoryReportServiceImp(StoryReportMapper storyReportMapper, StoryMapper storyMapper, UserMapper userMapper) {
        this.storyReportMapper = storyReportMapper;
        this.storyMapper = storyMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(StoryReportDto storyReport) {
        return storyReportMapper.insertOne(storyReport);
    }

    @Override
    public int modifyStatus(int sreportId, boolean status) {
        return storyReportMapper.updateStatus(sreportId, status);
    }

    @Override
    public StoryReportDto findStoryReport(int sreportId) {
        return storyReportMapper.selectBySreportId(sreportId);
    }

    @Override
    public List<StoryReportDto> storyReportList(int userId) {
        return storyReportMapper.listByUserId(userId);
    }
}
