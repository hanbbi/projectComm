package com.project.projectcomm.mapper;

import com.project.projectcomm.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insertOne(UserDto user);  // 사용자 등록
    int updateOne(UserDto user);  // 사용자 수정
    int updateStatus(int id, int status);  // 사용자 상태 수정
    int updateLetterOpen(int id, boolean letterOpen);  // 사용자 쪽지 수신 범위 수정
    int updateUserOpen(int id, boolean userOpen);
    int deleteByUserId(int id);  // 사용자 선택 삭제
    UserDto selectByUserId(int id);  // 해당 사용자 찾기
    UserDto selectByEmailAndPw(String userEmail, String userPw);  // 이메일, 비밀번호로 사용자 찾기
    UserDto selectByEmailAndName(String userEmail, String userName);  // 이메일, 이름으로 비밀번호 찾기
    List<UserDto> listAll();  // 사용자 전체 목록
}
