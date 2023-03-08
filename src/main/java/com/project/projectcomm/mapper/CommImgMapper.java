package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.CommImgDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommImgMapper {
    int insertOne(CommImgDto commImg);  // 커뮤니티 글에 이미지 등록
    int deleteByCommImgId(int id);  // 커뮤니티 글 속 이미지 전체 삭제?
    int deleteByCommImgIdAndSeq(int id, int seq);  // 커뮤니티 글 속 이미지 선택 삭제?
    CommImgDto selectByCommImgIdAndSeq(int id, int seq);  // 커뮤니티 글 속 해당 이미지 찾기
    List<CommImgDto> listByCommImgId(int id);  // 커뮤니티 글 속 이미지 목록
}
