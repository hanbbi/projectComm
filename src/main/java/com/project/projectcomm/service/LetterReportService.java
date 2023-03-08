package com.project.projectcomm.service;

import com.project.projectcomm.dto.LetterReportDto;

import java.util.List;

public interface LetterReportService {
    int register(LetterReportDto letterReport);
    int modifyStatus(int lreportId, boolean status);
    LetterReportDto findLetterReport(int lreportId);
    List<LetterReportDto> letterReportList(int userId);
}
