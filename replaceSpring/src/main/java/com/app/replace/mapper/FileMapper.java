package com.app.replace.mapper;

import com.app.replace.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface FileMapper {
    public void insert(FileVO fileVO);
    public Optional<FileVO> select(long memberId);
}
