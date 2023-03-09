package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserReportDto;

import java.util.List;

public interface UserReportService {
    int register(UserReportDto userReport);
    int modifyStatus(int ureportId, boolean status);
    UserReportDto findUserReport(int ureportId);
    List<UserReportDto> userReportList(int userId);
    List<UserReportDto> targetReportList(int targetId);
}
