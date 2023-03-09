package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.PagingDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommService {
    int register(List<MultipartFile> imgFileList, CommDto comm, String imgPath);
    int modifyOne(List<MultipartFile> imgFileList, CommDto comm, String imgPath, List<String> imgToDeleteList);
    int modifyOpen(int commId);
    int modifyStatus(int commId);
    int modifyViews(int commId);
    int removeOne(int commId);
    int removeAll(int userId);
    CommDto findComm(int commId);
    List<CommDto> commList(int userId);
    List<CommDto> listAll();
}
