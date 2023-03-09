package com.project.projectcomm.service;

import com.project.projectcomm.StaticMethods;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.dto.UserImgDto;
import com.project.projectcomm.mapper.UserImgMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public int modifyStatus(int userId, int status) {
        return userMapper.updateStatus(userId, status);
    }

    @Override
    public int modifyLetterOpen(int userId, boolean letter) {
        return userMapper.updateLetterOpen(userId, letter);
    }

    @Override
    public int modifyUserOpen(int userId, boolean user) {
        return userMapper.updateUserOpen(userId, user);
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

    @Override
    public Map<String, Boolean> checkIfExists(UserDto user) {
        Map<String, Boolean> checkMap = new HashMap<>();
        if(userMapper.selectByEmail(user.getUserEmail()) != null) {
            checkMap.put("userEmail", true);
        } else {
            checkMap.put("userEmail", false);
        }
        if(userMapper.selectByEmail(user.getUserPhone()) != null) {
            checkMap.put("userPhone", true);
        } else {
            checkMap.put("userPhone", false);
        }
        if(userMapper.selectByEmail(user.getUserNick()) != null) {
            checkMap.put("userNick", true);
        } else {
            checkMap.put("userNick", false);
        }
        return checkMap;
    }
}
