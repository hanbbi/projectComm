package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserDto;

public interface UserService {
    int register(UserDto user);
    int modifyOne(UserDto user);
    int modifyStatus(int userId, int userStatus);
    int modifyLetterOpen(int userId, boolean letterOpen);
    int modifyUserOpen(int userId, boolean userOpen);
    int removeOne(int userId);
    UserDto findOne(int userId);
    UserDto login(String userEmail, String userPw);
    UserDto findPw(String userEmail, String userName);

}
