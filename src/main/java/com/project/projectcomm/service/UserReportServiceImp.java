package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserReportDto;
import com.project.projectcomm.mapper.UserMapper;
import com.project.projectcomm.mapper.UserReportMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReportServiceImp implements UserReportService {
    private UserReportMapper userReportMapper;
    private UserMapper userMapper;

    public UserReportServiceImp(UserReportMapper userReportMapper, UserMapper userMapper) {
        this.userReportMapper = userReportMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(UserReportDto userReport) {
        return userReportMapper.insertOne(userReport);
    }

    @Override
    public int modifyStatus(int ureportId, boolean status) {
        return userReportMapper.updateStatus(ureportId, status);
    }

    @Override
    public UserReportDto findUserReport(int ureportId) {
        return userReportMapper.selectByUreportId(ureportId);
    }

    @Override
    public List<UserReportDto> userReportList(int userId) {
        return userReportMapper.listByUserId(userId);
    }

    @Override
    public List<UserReportDto> targetReportList(int targetId) {
        return userReportMapper.listByTargetId(targetId);
    }
}
