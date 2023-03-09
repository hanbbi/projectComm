package com.project.projectcomm.service;

import com.project.projectcomm.StaticMethods;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.dto.UserImgDto;
import com.project.projectcomm.mapper.UserImgMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private UserMapper userMapper;
    private UserImgMapper userImgMapper;
    public UserServiceImp(UserMapper userMapper, UserImgMapper userImgMapper) {
        this.userMapper = userMapper;
        this.userImgMapper = userImgMapper;
    }

    @Override
    public int register(UserDto user) {
        try {
            return userMapper.insertOne(user);
        } catch (Exception | Error e) {
            e.printStackTrace();
            throw new Error("사용자 등록 중 오류 발생");
        }
    }

    @Override
    public int modifyOne(UserDto user) {
        return userMapper.updateOne(user);
    }

    @Override
    public int modifyStatus(int userId) {
        return userMapper.updateStatus(userId);
    }

    @Override
    public int modifyLetterOpen(int userId) {
        return userMapper.updateLetterOpen(userId);
    }

    @Override
    public int modifyUserOpen(int userId) {
        return userMapper.updateUserOpen(userId);
    }

    @Override
    public int removeOne(int userId) {
        return userMapper.deleteByUserId(userId);
    }

    @Override
    public UserDto findOne(int userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public UserDto login(String userEmail, String userPw) {
        return userMapper.selectByEmailAndPw(userEmail, userPw);
    }

    @Override
    public UserDto findPw(String userEmail, String userName) {
//        UserDto user = userMapper.selectByEmailAndName(userEmail, userName);
//        if (user != null) {
//            try {
//                String title = "MINISTAGRAM 계정 비밀번호 재설정";
//                String content = "http://localhost:5555/user/" + user.getUserId() + "/userPw_reset.do";
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return user;
        return userMapper.selectByEmailAndName(userEmail, userName);
    }
}
