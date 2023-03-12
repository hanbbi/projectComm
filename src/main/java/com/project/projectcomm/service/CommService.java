package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.PagingDto;
import com.project.projectcomm.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface CommService {
    int register(List<MultipartFile> imgFileList, CommDto comm, UserDto loginUser, HashSet<String> cateIdList, String imgPath);
    int modifyOne(List<MultipartFile> imgFileList, CommDto comm, UserDto loginUser, HashSet<String> cateIdList, String imgPath, List<String> imgToDeleteList);
    int modifyOpen(int commId, boolean open);
    int modifyStatus(int commId, boolean status);
    int modifyViews(int commId);
    int removeOne(int commId);
    int removeAll(int userId);
    CommDto findComm(int commId);
    List<CommDto> commList(int userId);
    List<CommDto> listAll();
    List<CommDto> cateList(Map<String, Object> map);
}
