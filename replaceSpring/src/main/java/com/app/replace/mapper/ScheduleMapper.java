package com.app.replace.mapper;

import com.app.replace.dto.ScheduleDTO;
import com.app.replace.vo.ScheduleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    public List<ScheduleDTO> selectAllTrainerSchedule(String dateFilter);
}
