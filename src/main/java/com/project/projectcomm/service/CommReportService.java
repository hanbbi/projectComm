package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommReportDto;

import java.util.List;

public interface CommReportService {
    int register(CommReportDto commReport);
    int modifyStatus(int creportId, boolean status);
    CommReportDto findCommReport(int creportId);
    List<CommReportDto> commReportList(int userId);
}
