package com.app.replace.dao;

import com.app.replace.mapper.DocumentMapper;
import com.app.replace.vo.DocumentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DocumentDAO {
    private final DocumentMapper documentMapper;
    public void insert(DocumentVO documentVO){
        documentMapper.insert(documentVO);
    }
    public List<DocumentVO> selectAll(long memberId){
        return documentMapper.selectAll(memberId);
    }
}
