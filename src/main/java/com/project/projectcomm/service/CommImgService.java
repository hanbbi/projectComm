package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommImgDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommImgService {
    int register(CommImgDto commImg);
    int registerMultipartImg(MultipartFile imgFile, String imgPath, String imgId, int seq) throws Exception;
    int removeOne(String commImgId);
    int removeOneAt(String commImgId, int seq);
    CommImgDto findCommImgAt(String commImgId, int seq);
    List<CommImgDto> commImgList(String commImgId);
}
