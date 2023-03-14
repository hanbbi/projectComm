package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.CommLikesViewDto;
import com.project.projectcomm.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommMapper {
    int insertOne(CommDto comm);  // 커뮤니티 글 등록
    int updateOne(CommDto comm);  // 커뮤니티 글 수정
    int updateOpen(int id, boolean open);  // 커뮤니티 글 공개 범위 수정
    int updateStatus(int id, boolean status);  // 커뮤니티 글 상태 수정
    int updateViews(int id);  // 커뮤니티 글 조회수 수정
    int deleteByCommId(int id);  // 커뮤니티 글 선택 삭제
    int deleteByUserId(int id);  // 사용자가 작성한 모든 커뮤니티 글 삭제
    int countByUserId(int id);  // 해당 사용자가 작성한 커뮤니티 글 수
    CommDto selectByCommId(int id);  // 해당 커뮤니티 글 찾기
    List<CommDto> listByUserId(int id);  // 해당 사용자가 작성한 커뮤니티 글 목록
    List<CommDto> listAll();  // 전체 커뮤니티 글 목록
    List<CommDto> cateList(Map<String, Object> map);
    CommLikesViewDto countLikesByCommId(int id);
}
