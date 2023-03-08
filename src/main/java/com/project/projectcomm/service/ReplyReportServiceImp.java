package com.project.projectcomm.service;

import com.project.projectcomm.dto.ReplyReportDto;
import com.project.projectcomm.mapper.ReplyMapper;
import com.project.projectcomm.mapper.ReplyReportMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyReportServiceImp implements ReplyReportService {
    private ReplyReportMapper replyReportMapper;
    private ReplyMapper replyMapper;
    private UserMapper userMapper;

    public ReplyReportServiceImp(ReplyReportMapper replyReportMapper, ReplyMapper replyMapper, UserMapper userMapper) {
        this.replyReportMapper = replyReportMapper;
        this.replyMapper = replyMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(ReplyReportDto replyReport) {
        return replyReportMapper.insertOne(replyReport);
    }

    @Override
    public int modifyStatus(int rreportId, boolean status) {
        return replyReportMapper.updateStatus(rreportId, status);
    }

    @Override
    public ReplyReportDto findReplyReport(int rreportId) {
        return replyReportMapper.selectByRreportId(rreportId);
    }

    @Override
    public List<ReplyReportDto> replyReportList(int userId) {
        return replyReportMapper.listByUserId(userId);
    }
}
