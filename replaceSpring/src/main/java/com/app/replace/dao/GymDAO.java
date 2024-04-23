package com.app.replace.dao;

import com.app.replace.mapper.GymMapper;
import com.app.replace.vo.GymVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GymDAO {
    private final GymMapper gymMapper;

    public void insert(GymVO gymVO){
        gymMapper.insert(gymVO);
    }
    public List<GymVO> selectAll(){
        return gymMapper.selectAll();
    }
}
