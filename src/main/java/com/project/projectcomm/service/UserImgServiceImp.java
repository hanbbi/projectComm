package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserImgDto;
import com.project.projectcomm.mapper.UserImgMapper;
import org.springframework.stereotype.Service;

@Service
public class UserImgServiceImp implements UserImgService {
    private UserImgMapper userImgMapper;

    public UserImgServiceImp(UserImgMapper userImgMapper) {
        this.userImgMapper = userImgMapper;
    }

    @Override
    public int register(UserImgDto userImg) {
        return userImgMapper.insertOne(userImg);
    }

    @Override
    public int removeOne(String userImgId) {
        return userImgMapper.deleteByUserImgId(userImgId);
    }

    @Override
    public UserImgDto findUserImg(int userId) {
        return userImgMapper.selectByUserId(userId);
    }
}
