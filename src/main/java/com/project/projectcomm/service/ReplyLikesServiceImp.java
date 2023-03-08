package com.project.projectcomm.service;

import com.project.projectcomm.dto.ReplyLikesDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.mapper.ReplyLikesMapper;
import com.project.projectcomm.mapper.ReplyMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyLikesServiceImp implements ReplyLikesService {
    ReplyLikesMapper replyLikesMapper;
    ReplyMapper replyMapper;
    UserMapper userMapper;

    public ReplyLikesServiceImp(ReplyLikesMapper replyLikesMapper, ReplyMapper replyMapper, UserMapper userMapper) {
        this.replyLikesMapper = replyLikesMapper;
        this.replyMapper = replyMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(ReplyLikesDto replyLikes) {
        ReplyLikesDto replyLikesDto = replyLikesMapper.selectByUserIdAndReplyId(replyLikes.getUserId(), replyLikes.getReplyId());
        if (replyLikesDto != null) return 0;
        return replyLikesMapper.insertOne(replyLikes);
    }

    @Override
    public int removeOne(int rlikesId) {
        return replyLikesMapper.deleteByRlikesId(rlikesId);
    }

    @Override
    public int removeAll(int userId) {
        return replyLikesMapper.deleteByUserId(userId);
    }

    @Override
    public int countReplyLikes(int replyId) {
        return replyLikesMapper.countByReplyId(replyId);
    }

    @Override
    public ReplyLikesDto findReplyLikes(UserDto loginUser, int replyId) {
        return replyLikesMapper.selectByUserIdAndReplyId(loginUser.getUserId(), replyId);
    }

    @Override
    public List<ReplyLikesDto> replyLikesList(int userId) {
        return replyLikesMapper.listByUserId(userId);
    }
}
