package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.CommLikesDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.mapper.CommLikesMapper;
import com.project.projectcomm.mapper.CommMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

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
        CommLikesDto commLikesDto = commLikesMapper.selectByUserIdAndCommId(commLikes.getUserId(), commLikes.getCommId());
        if (commLikesDto != null) return 0;
        return commLikesMapper.insertOne(commLikes);
    }

    @Override
    public int removeOne(int clikesId) {
        return commLikesMapper.deleteByClikesId(clikesId);
    }

    @Override
    public int removeAll(int userId) {
        return commLikesMapper.deleteByUserId(userId);
    }

    @Override
    public int countCommLikes(int commId) {
        return commLikesMapper.countByCommId(commId);
    }

    @Override
    public CommLikesDto findCommLikes(UserDto loginUser, int commId) {
        return commLikesMapper.selectByUserIdAndCommId(loginUser.getUserId(), commId);
    }

    @Override
    public List<CommLikesDto> commLikesList(int userId) {
        return commLikesMapper.listByUserId(userId);
    }

    @Override
    public Map<String, CommLikesDto> likesCheck(List<CommDto> commList, UserDto loginUser) {
        Map<String, CommLikesDto> commLikesMap = new HashMap<>();
        for (CommDto c : commList) {
            CommLikesDto commLikes = commLikesMapper.selectByUserIdAndCommId(c.getUserId(), c.getCommId());
            commLikesMap.put(""+c.getCommId(), commLikes);
        }
        return commLikesMap;
    }
}
