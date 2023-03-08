package com.project.projectcomm.service;

import com.project.projectcomm.dto.LetterReportDto;
import com.project.projectcomm.mapper.LetterReportMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterReportServiceImp implements LetterReportService {
    private LetterReportMapper letterReportMapper;

    public LetterReportServiceImp(LetterReportMapper letterReportMapper) {
        this.letterReportMapper = letterReportMapper;
    }

    @Override
    public int register(LetterReportDto letterReport) {
        return letterReportMapper.insertOne(letterReport);
    }

    @Override
    public int modifyStatus(int lreportId, boolean status) {
        return letterReportMapper.updateStatus(lreportId, status);
    }

    @Override
    public LetterReportDto findLetterReport(int lreportId) {
        return letterReportMapper.selectByLreportId(lreportId);
    }

    @Override
    public List<LetterReportDto> letterReportList(int userId) {
        return letterReportMapper.listByUserId(userId);
    }
}
