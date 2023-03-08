package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserImgDto;

public interface UserImgService {
    int register(UserImgDto userImg);
    int removeOne(int userImgId);
    UserImgDto findUserImg(int userId);
}
