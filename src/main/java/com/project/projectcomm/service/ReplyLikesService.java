package com.project.projectcomm.service;

import com.project.projectcomm.dto.ReplyLikesDto;
import com.project.projectcomm.dto.UserDto;

import java.util.List;

public interface ReplyLikesService {
    int register(ReplyLikesDto replyLikes);
    int removeOne(int rlikesId);
    int removeAll(int userId);
    int countReplyLikes(int replyId);
    ReplyLikesDto findReplyLikes(UserDto loginUser, int replyId);
    List<ReplyLikesDto> replyLikesList(int userId);
}
