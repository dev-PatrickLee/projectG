package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LockerVO {
    long id;
    int lockerNumber;
    String lockerGender;
    String lockerPassword;
    String lockerExpireDate;
    int lockerRemainDate;
    String lockerStatus;
    long memberId;
    long gymId;
}

//    TBL_LOCKER
//      ID (PK)
//      NUMBER
//      END_DATE
//      TYPE
//      STORE_ID (FK) 지점
//      MEMBER_ID (FK) 사용자
//