package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserDto;

import java.util.Map;

public interface UserService {
    int register(UserDto user);
    int modifyOne(UserDto user);
    int modifyStatus(int userId, int status);
    int modifyLetterOpen(int userId, boolean letter);
    int modifyUserOpen(int userId, boolean user);
    int removeOne(int userId);
    UserDto findOne(int userId);
    UserDto login(String userEmail, String userPw);
    UserDto findPw(String userEmail, String userName);
    Map<String, Boolean> checkIfExists(UserDto user);

}
