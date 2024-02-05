package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StoreVO {
    long id;
    String storeName;
    String storeZipcode;
    String storeAddress;
    String storeAddressDetail;
    String storePhone;

}
//    TBL_MEMBER
//      ID (PK)
//      NAME
//      EMAIL
//      PASSWORD
//      PHONE
//      GENDER
//      BIRTHDAY
//      ZIPCODE
//      ADDRESS
//      ADDRESS_DETAIL
//      ENROLL_DATE
//      ENROLL_TYPE
//      GOAL
//      INTEREST
//      WORKOUT_HOUR
//      RF
//      VISIT_PATH
//      SMS_AGREEMENT
//      TM_AGREEMENT
//      SELF_WORKOUT_AGREEMENT
//      TYPE
//      MEMO
//      STORE_ID (FK)
//
//    TBL_PURCHASE_HISTORY
//      ID (PK)
//      PURCHASE_DATE
//      MEMBER_ID
//      PRODUCT_ID (FK)
//      STORE_ID (FK) 결제지점
//      STAFF_ID (FK) 결제자
//
//    TBL_VISIT_HISTORY
//      ID (PK)
//      VISIT_DATE
//      STORE_ID
//      MEMBER_ID (FK)
//
//    TBL_SCHEDULE
//      ID (PK)
//      DATE
//      START_TIME
//      END_TIME
//      STAFF_ID (FK)
//
//
//
