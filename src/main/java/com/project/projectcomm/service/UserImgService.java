package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserImgDto;

public interface UserImgService {
    int register(UserImgDto userImg);
    int modifyOne(String userImgId);
    int removeOne(String userImgId);
    UserImgDto findUserImg(String userImgId);
}
