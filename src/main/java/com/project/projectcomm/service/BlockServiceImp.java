package com.project.projectcomm.service;

import com.project.projectcomm.dto.BlockDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.mapper.BlockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImp implements BlockService {
    BlockMapper blockMapper;

    public BlockServiceImp(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    @Override
    public int register(BlockDto block) {
        BlockDto blockDto = blockMapper.selectByUserIdAndTargetId(block.getUserId(), block.getTargetId());
        if (blockDto != null) return 0;
        return blockMapper.insertOne(block);
    }

    @Override
    public int removeOne(int userId, int targetId) {
        return blockMapper.deleteByTargetId(userId, targetId);
    }

    @Override
    public int removeAll(int userId) {
        return blockMapper.deleteByUserId(userId);
    }

    @Override
    public int countBlock(int userId) {
        return blockMapper.countByUserId(userId);
    }

    @Override
    public BlockDto findBlock(UserDto loginUser, int targetId) {
        return blockMapper.selectByUserIdAndTargetId(loginUser.getUserId(), targetId);
    }

    @Override
    public List<BlockDto> blockList(int userId) {
        return blockMapper.listByUserId(userId);
    }
}
