package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StaffVO {
    long id;
    String staffRank;
    String staffMainTask;
    long memberId;
}

//    TBL_STAFF
//      ID (PK)
//      RANK
//      MAIN_TASK
//      MEMBER_ID (FK)
//
