package com.app.replace.dao;

import com.app.replace.mapper.FileMapper;
import com.app.replace.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    public void insert(FileVO fileVO){
        fileMapper.insert(fileVO);
    }
    public Optional<FileVO> select(long memberId){
        return fileMapper.select(memberId);
    }
}
