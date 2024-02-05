package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ScheduleVO {
    long id;
    String scheduleDate;
    String scheduleEndTime;
    long staffId;
}
//    TBL_SCHEDULE
//      ID (PK)
//      DATE
//      START_TIME
//      END_TIME
//      STAFF_ID (FK)
//