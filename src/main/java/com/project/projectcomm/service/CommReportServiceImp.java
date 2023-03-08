package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommReportDto;
import com.project.projectcomm.mapper.CommMapper;
import com.project.projectcomm.mapper.CommReportMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommReportServiceImp implements CommReportService {
    private CommReportMapper commReportMapper;
    private CommMapper commMapper;
    private UserMapper userMapper;

    public CommReportServiceImp(CommReportMapper commReportMapper, CommMapper commMapper, UserMapper userMapper) {
        this.commReportMapper = commReportMapper;
        this.commMapper = commMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(CommReportDto commReport) {
        return commReportMapper.insertOne(commReport);
    }

    @Override
    public int modifyStatus(int creportId, boolean status) {
        return commReportMapper.updateStatus(creportId, status);
    }

    @Override
    public CommReportDto findCommReport(int creportId) {
        return commReportMapper.selectByCreportId(creportId);
    }

    @Override
    public List<CommReportDto> commReportList(int userId) {
        return commReportMapper.listByUserId(userId);
    }
}
