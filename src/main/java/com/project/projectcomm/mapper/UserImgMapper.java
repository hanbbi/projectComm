package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.UserImgDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserImgMapper {
    int insertOne(UserImgDto userImg);  // 사용자 프로필 사진 등록
    int deleteByUserImgId(String id);  // 사용자 프로필 사진 삭제
    UserImgDto selectByUserId(int id);  // 해당 사용자의 프로필 사진 찾기
}
