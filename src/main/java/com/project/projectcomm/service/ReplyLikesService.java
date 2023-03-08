package com.project.projectcomm.service;

import com.project.projectcomm.dto.ReplyLikesDto;

import java.util.List;

public interface ReplyLikesService {
    int register(ReplyLikesDto replyLikes);
    int removeOne(int rlikesId);
    int removeAll(int userId);
    int countReplyLikes(int replyId);
    ReplyLikesDto findReplyLikes(int userId, int replyId);
    List<ReplyLikesDto> replyLikesList(int userId);
}
