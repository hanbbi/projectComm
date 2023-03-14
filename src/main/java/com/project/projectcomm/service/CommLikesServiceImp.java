package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.CommLikesDto;
import com.project.projectcomm.dto.CommLikesViewDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.mapper.CommLikesMapper;
import com.project.projectcomm.mapper.CommMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommLikesServiceImp implements CommLikesService {
    CommLikesMapper commLikesMapper;
    CommMapper commMapper;
    UserMapper userMapper;

    public CommLikesServiceImp(CommLikesMapper commLikesMapper, CommMapper commMapper, UserMapper userMapper) {
        this.commLikesMapper = commLikesMapper;
        this.commMapper = commMapper;
        this.userMapper = userMapper;
    }


    @Override
    public int register(CommLikesDto commLikes) {
        return commLikesMapper.insertOne(commLikes);
    }

    @Override
    public int remove(int clikesId) {
        return commLikesMapper.deleteByClikesId(clikesId);
    }

    @Override
    public int modify(CommLikesDto commLikes) {
        return commLikesMapper.update(commLikes);
    }

    @Override
    public CommLikesDto find(int commId, int loginUserId) {
        CommLikesDto commLikes = commLikesMapper.selectByCommIdAndUserId(commId, loginUserId);
        return commLikes;
    }
    @Transactional
    @Override
    public CommLikesViewDto findCommLikes(int commId, int loginUserId) {
        CommLikesViewDto commLikesView = commMapper.countLikesByCommId(commId);
        if (loginUserId != 0) {
            CommLikesDto commLikes = commLikesMapper.selectByCommIdAndUserId(commId, loginUserId);
            commLikesView.setCommLikes(commLikes);
        }
        return commLikesView;
    }

    @Override
    public List<CommLikesDto> commLikesList(int userId) {
        return commLikesMapper.listByUserId(userId);
    }
}
