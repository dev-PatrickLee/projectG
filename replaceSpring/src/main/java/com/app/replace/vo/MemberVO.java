package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private long id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String memberPhone;
    private String memberZipcode;
    private String memberAddress;
    private String memberAddressDetail;
    private String memberEnrollDate;
    private String memberRfCard;
    private String memberAge;
    private long gymId;
}
