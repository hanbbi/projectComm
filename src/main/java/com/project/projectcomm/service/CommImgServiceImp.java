package com.project.projectcomm.service;

import com.project.projectcomm.dto.CommImgDto;
import com.project.projectcomm.mapper.CommImgMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service
public class CommImgServiceImp implements CommImgService {
    private CommImgMapper commImgMapper;

    public CommImgServiceImp(CommImgMapper commImgMapper) {
        this.commImgMapper = commImgMapper;
    }

    @Override
    public int register(CommImgDto commImg) {
        if (commImg != null) return commImgMapper.insertOne(commImg);
        else return 1;
    }

    @Override
    public int registerMultipartImg(MultipartFile imgFile, String imgPath, String imgId, int seq) throws Exception {
        int register = 0;
        String[] contentsTypes = Objects.requireNonNull(imgFile.getContentType().split("/"));

        if (contentsTypes[0].equals("image")) {
            String fileName = imgId + "_" + System.currentTimeMillis() + "_"
                    +(int)(Math.random()*10000)+"."+contentsTypes[1];
            Path path = Paths.get(imgPath+"/" + fileName);
            imgFile.transferTo(path);
            CommImgDto commImg = new CommImgDto();
            commImg.setImgPath(fileName);
            commImg.setCommImgId(imgId);
            commImg.setSeq(seq);
            register = commImgMapper.insertOne(commImg);
        } else {
            throw new Exception("이미지 파일이 아닙니다.");
        }

        return register;
    }

    @Override
    public int removeOne(String commImgId) {
        return commImgMapper.deleteByCommImgId(commImgId);
    }

    @Override
    public int removeOneAt(String commImgId, int seq) {
        return commImgMapper.deleteByCommImgIdAndSeq(commImgId, seq);
    }

    @Override
    public CommImgDto findCommImgAt(String commImgId, int seq) {
        return commImgMapper.selectByCommImgIdAndSeq(commImgId, seq);
    }

    @Override
    public List<CommImgDto> commImgList(String commImgId) {
        return commImgMapper.listByCommImgId(commImgId);
    }
}
