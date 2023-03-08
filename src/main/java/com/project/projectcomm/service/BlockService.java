package com.project.projectcomm.service;

import com.project.projectcomm.dto.BlockDto;

import java.util.List;

public interface BlockService {
    int register(BlockDto block);
    int removeOne(int targetId);
    int removeAll(int userId);
    int countBlock(int userId);
    BlockDto findBlock(int userId, int targetId);
    List<BlockDto> blockList(int userId);
}
