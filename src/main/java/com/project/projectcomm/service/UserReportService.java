package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserReportDto;

import java.util.List;

public interface UserReportService {
    int reigster(UserReportDto userReport);
    int modifyStatus(int ureportId, boolean status);
    UserReportDto findUserReport(int ureportId);
    List<UserReportDto> userReportList(int userId);
}
