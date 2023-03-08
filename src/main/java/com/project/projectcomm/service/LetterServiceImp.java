package com.project.projectcomm.service;

import com.project.projectcomm.dto.LetterDto;
import com.project.projectcomm.mapper.LetterMapper;
import com.project.projectcomm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterServiceImp implements LetterService {
    private LetterMapper letterMapper;
    private UserMapper userMapper;

    public LetterServiceImp(LetterMapper letterMapper, UserMapper userMapper) {
        this.letterMapper = letterMapper;
        this.userMapper = userMapper;
    }

    @Override
    public int register(LetterDto letter) {
        LetterDto letterDto = letterMapper.selectByUserIdAndSenderId(letter.getUserId(), letter.getSenderId());
        if (letterDto != null) return letterMapper.updateContent(letter.getLetterId(), letter.getContent());
        return letterMapper.insertOne(letter);
    }

    @Override
    public int modifyContent(int letterId, String content) {
        return letterMapper.updateContent(letterId, content);
    }

    @Override
    public int modifyStatus(int letterId, int status) {
        return letterMapper.updateStatus(letterId, status);
    }

    @Override
    public int removeOne(int userId, int senderId) {
        return letterMapper.deleteByUserIdAndSenderId(userId, senderId);
    }

    @Override
    public int removeAll(int userId) {
        return letterMapper.deleteByUserId(userId);
    }

    @Override
    public int countLetter(int userId) {
        return letterMapper.countByUserId(userId);
    }

    @Override
    public LetterDto findLetter(int userId, int senderId) {
        return letterMapper.selectByUserIdAndSenderId(userId, senderId);
    }

    @Override
    public List<LetterDto> letterList(int userId) {
        return letterMapper.listByUserId(userId);
    }
}
