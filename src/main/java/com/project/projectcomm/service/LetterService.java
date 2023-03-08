package com.project.projectcomm.service;

import com.project.projectcomm.dto.LetterDto;

import java.util.List;

public interface LetterService {
    int register(LetterDto letter);
    int modifyContent(int letterId, String content);
    int modifyStatus(int letterId, int status);
    int removeOne(int userId, int senderId);
    int removeAll(int userId);
    int countLetter(int userId);
    LetterDto findLetter(int userId, int senderId);
    List<LetterDto> letterList(int userId);
}
