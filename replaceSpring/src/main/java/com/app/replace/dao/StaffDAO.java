package com.app.replace.dao;

import com.app.replace.dto.StaffDTO;
import com.app.replace.mapper.StaffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StaffDAO {
    private final StaffMapper staffMapper;

    public void insert(StaffDTO staffDTO){
        staffMapper.insert(staffDTO);
    }
    public List<StaffDTO> selectAll(){
        return staffMapper.selectAll();
    }
}
