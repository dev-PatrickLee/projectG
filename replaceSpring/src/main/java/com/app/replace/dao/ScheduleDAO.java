package com.app.replace.dao;

import com.app.replace.dto.ScheduleDTO;
import com.app.replace.mapper.ScheduleMapper;
import com.app.replace.vo.ScheduleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleDAO {
    private final ScheduleMapper scheduleMapper;

    public List<ScheduleDTO> selectAllTrainerSchedule(String dateFilter){
        return scheduleMapper.selectAllTrainerSchedule(dateFilter);
    }
}
