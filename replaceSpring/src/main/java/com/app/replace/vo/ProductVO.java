package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProductVO {
    long id;
    String productName;
    int productExpireDates;
    int productPrice;
    long gymId;
}
//    TBL_PRODUCT
//      ID (PK)
//      NAME
//      PRICE
//      STAFF_ID (FK) 담당강사
//      PRODUCT_EXPIRE_DATES