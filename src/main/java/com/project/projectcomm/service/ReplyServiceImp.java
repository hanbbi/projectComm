package com.project.projectcomm.service;

import com.project.projectcomm.dto.ReplyDto;
import com.project.projectcomm.mapper.ReplyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImp implements ReplyService {
    private ReplyMapper replyMapper;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public ReplyServiceImp(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    @Override
    public int register(ReplyDto reply) {
        return replyMapper.insertOne(reply);
    }

    @Override
    public int modifyOne(ReplyDto reply) {
        return replyMapper.updateOne(reply);
    }

    @Override
    public int modifyStatus(int replyId) {
        return replyMapper.updateStatus(replyId);
    }

    @Override
    public int removeOne(int replyId) {
        return replyMapper.deleteByReplyId(replyId);
    }

    @Override
    public int removeAll(int userId) {
        return replyMapper.deleteByUserId(userId);
    }

    @Override
    public int countCommReply(int commId) {
        return replyMapper.countByCommId(commId);
    }

    @Override
    public int countUserReply(int userId) {
        return replyMapper.countByUserId(userId);
    }

    @Override
    public ReplyDto findReply(int replyId) {
        return replyMapper.selectByReplyId(replyId);
    }

    @Override
    public List<ReplyDto> commReplyList(int commId) {
        return replyMapper.listByCommId(commId);
    }

    @Override
    public List<ReplyDto> userReplyList(int userId) {
        return replyMapper.listByUserId(userId);
    }

    @Override
    public List<ReplyDto> fkReplyList(int fkReplyId) {
        return replyMapper.listByFkReplyId(fkReplyId);
    }
}
