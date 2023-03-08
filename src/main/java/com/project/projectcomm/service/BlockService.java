package com.project.projectcomm.service;

import com.project.projectcomm.dto.BlockDto;
import com.project.projectcomm.dto.UserDto;

import java.util.List;

public interface BlockService {
    int register(BlockDto block);
    int removeOne(int userId, int targetId);
    int removeAll(int userId);
    int countBlock(int userId);
    BlockDto findBlock(UserDto loginUser, int targetId);
    List<BlockDto> blockList(int userId);
}
