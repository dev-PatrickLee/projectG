package com.app.replace.mapper;

import com.app.replace.vo.GymVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GymMapper {
    public void insert(GymVO gymVO);

    public List<GymVO> selectAll();
}
