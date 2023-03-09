package com.project.projectcomm.service;

import com.project.projectcomm.dto.UserImgDto;

public interface UserImgService {
    int register(UserImgDto userImg);
    int modifyOne(UserImgDto userImg);
    int removeOne(String userImgId);
    UserImgDto findUserImg(String userImgId);
}
