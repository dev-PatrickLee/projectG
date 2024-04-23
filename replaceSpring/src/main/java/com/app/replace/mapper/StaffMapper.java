package com.app.replace.mapper;

import com.app.replace.dto.StaffDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffMapper {
    public void insert(StaffDTO staffDTO);

    public List<StaffDTO> selectAll();
}
