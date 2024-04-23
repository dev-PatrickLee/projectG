package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ScheduleVO {
    long id;
    String scheduleName;
    String scheduleType;
    int scheduleStartHour;
    int scheduleStartMin;
    int scheduleEndHour;
    int scheduleEndMin;
    String scheduleDate;
    int staffId;
}

