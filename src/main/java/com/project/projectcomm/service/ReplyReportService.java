package com.project.projectcomm.service;

import com.project.projectcomm.dto.ReplyReportDto;

import java.util.List;

public interface ReplyReportService {
    int register(ReplyReportDto replyReport);
    int modifyStatus(int rreportId, boolean status);
    ReplyReportDto findReplyReport(int rreportId);
    List<ReplyReportDto> replyReportList(int userId);
}
