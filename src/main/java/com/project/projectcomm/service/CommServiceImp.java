package com.project.projectcomm.service;

import com.project.projectcomm.StaticMethods;
import com.project.projectcomm.dto.*;
import com.project.projectcomm.mapper.CateConnMapper;
import com.project.projectcomm.mapper.CommImgMapper;
import com.project.projectcomm.mapper.CommMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
public class CommServiceImp implements CommService {
    private CommMapper commMapper;
    private CommImgMapper commImgMapper;
    private CateConnMapper cateConnMapper;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public CommServiceImp(CommMapper commMapper, CommImgMapper commImgMapper, CateConnMapper cateConnMapper) {
        this.commMapper = commMapper;
        this.commImgMapper = commImgMapper;
        this.cateConnMapper = cateConnMapper;
    }

    @Override
    @Transactional
    public int register(List<MultipartFile> imgFileList, CommDto comm, UserDto loginUser, HashSet<String> cateIdList, String imgPath) {
        if (commMapper.insertOne(comm) <= 0) throw new Error("커뮤니티 글 등록에 문제가 발생했습니다.");
        comm.setCommImgId(""+comm.getCommId());
        if (commMapper.updateOne(comm) <= 0) throw new Error("커뮤니티 이미지 수정에 문제가 발생했습니다.");

        for (String cateId : cateIdList) {
            if (!cateId.isBlank()) {
                CateConnDto cateConn = new CateConnDto();
                cateConn.setCommId(comm.getCommId());
                cateConn.setCateId(cateId);
                if (cateConnMapper.insertOne(cateConn) <= 0) throw new Error();
            }
        }

        try {
            System.out.println(imgFileList.size());
            for (int i = 0; i < imgFileList.size(); i++) {
                System.out.println("imgFileList imageFile: "+imgFileList.get(i));
                if (imgFileList.size() > 1) {
                    CommImgDto commImg = StaticMethods.parseIntoCommImg(imgFileList.get(i), comm.getCommImgId(), imgPath + "/comm", i+1);
                    if (commImgMapper.insertOne(commImg) <= 0) throw new Error();
                }
            }
            System.out.println("commServiceImp commImg insert");
            return 1;
        } catch (Exception | Error e) {
            e.printStackTrace();
            throw new Error("커뮤니티 글 저장 중 문제가 발생했습니다.");
        }
    }

    @Override
    @Transactional
    public int modifyOne(List<MultipartFile> imgFileList, CommDto comm, UserDto loginUser, HashSet<String> cateIdList, String imgPath, List<String> imgToDeleteList) {
        comm.setCommImgId(""+comm.getCommId());
        System.out.println("commImgId 세팅 완료");

        List<CommImgDto> commImgDeleteList = new ArrayList<>();
        log.info("imgFileList service : " + imgFileList);

        try {
            if (commMapper.updateOne(comm) <= 0) throw new Error("커뮤니티 글 수정 중 문제가 발생했습니다.");
            cateConnMapper.deleteByCommId(comm.getCommId());

            for (String cateId : cateIdList) {
                if (!cateId.isBlank()) {
                    CateConnDto cateConn = new CateConnDto();
                    cateConn.setCommId(comm.getCommId());
                    cateConn.setCateId(cateId);
                    if (cateConnMapper.insertOne(cateConn) <= 0) throw new Error();
                } else {
                    log.info("등록될 카테고리가 없습니다.");
                }
            }
            System.out.println("카테고리 변경 완료");

            if (commImgDeleteList != null) {
                for (String imgValue : imgToDeleteList) {
                    String commImgId = imgValue.split("/")[0];
                    int seq = Integer.parseInt(imgValue.split("/")[1]);
                    commImgDeleteList.add(commImgMapper.selectByCommImgIdAndSeq(commImgId, seq));
                    commImgMapper.deleteByCommImgIdAndSeq(commImgId, seq);
                }
            }
            System.out.println("이미지 삭제 완료");

            List<CommImgDto> commImgList = commImgMapper.listByCommImgId(comm.getCommImgId());
            commImgMapper.deleteByCommImgId(comm.getCommImgId());

            if (imgFileList != null) {
                for (int i = 0; i < imgFileList.size(); i++) {
                    CommImgDto commImg = StaticMethods.parseIntoCommImg(imgFileList.get(i), comm.getCommImgId(), imgPath + "/comm", i + 1);
                    if (commImg != null) commImgList.add(commImg);
                    else log.error("이미지 파일이 아닙니다.");
                }

                for (int i = 0; i < commImgList.size(); i++) {
                    commImgList.get(i).setSeq(i + 1);
                    if (commImgMapper.insertOne(commImgList.get(i)) <= 0) throw new Error("이미지 순번 등록 중 문제가 발생했습니다.");
                }
            }
            System.out.println("이미지 등록 완료");

            for (CommImgDto deletedImg : commImgDeleteList) {
                File file = new File(imgPath + "/comm/" + deletedImg.getImgPath());
                boolean del = file.delete();
                log.info(deletedImg.getImgPath() + "삭제 완료 : " + del);
            }
            System.out.println("순번 재설정 완료");

            return 1;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public int modifyOpen(int commId, boolean open) {
        return commMapper.updateOpen(commId, open);
    }

    @Override
    public int modifyStatus(int commId, boolean status) {
        return commMapper.updateStatus(commId, status);
    }

    @Override
    public int modifyViews(int commId) {
        return commMapper.updateViews(commId);
    }

    @Override
    public int removeOne(int commId) {
        return commMapper.deleteByCommId(commId);
    }

    @Override
    public int removeAll(int userId) {
        return commMapper.deleteByUserId(userId);
    }

    @Override
    public CommDto findComm(int commId) {
        commMapper.updateViews(commId);
        return commMapper.selectByCommId(commId);
    }

    @Override
    public List<CommDto> commList(int userId) {
        return commMapper.listByUserId(userId);
    }

    @Override
    public List<CommDto> listAll() {
        return commMapper.listAll();
    }

    @Override
    public List<CommDto> cateList(Map<String, Object> map) {
        return commMapper.cateList(map);
    }
}
