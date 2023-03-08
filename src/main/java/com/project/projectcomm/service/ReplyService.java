package com.project.projectcomm.service;

import com.project.projectcomm.dto.ReplyDto;

import java.util.List;

public interface ReplyService {
    int register(ReplyDto reply);
    int modifyOne(ReplyDto reply);
    int modifyStatus(int replyId, boolean status);
    int removeOne(int replyId);
    int removeAll(int userId);
    int countCommReply(int commId);
    int countUserReply(int userId);
    ReplyDto findReply(int replyId);
    List<ReplyDto> commReplyList(int commId);
    List<ReplyDto> userReplyList(int userId);
}
