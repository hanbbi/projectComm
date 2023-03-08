package com.project.projectcomm.service;

import com.project.projectcomm.dto.StoryReportDto;

import java.util.List;

public interface StoryReportService {
    int register(StoryReportDto storyReport);
    int modifyStatus(int sreportId, boolean status);
    StoryReportDto findStoryReport(int sreportId);
    List<StoryReportDto> storyReportList(int userId);
}
