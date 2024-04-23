package com.app.replace.mapper;

import com.app.replace.vo.DocumentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DocumentMapper {
    public void insert(DocumentVO documentVO);
    public List<DocumentVO> selectAll(long memberId);
}
