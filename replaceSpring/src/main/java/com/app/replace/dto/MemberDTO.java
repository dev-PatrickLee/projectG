package com.app.replace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberDTO {
    private long id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String memberPhone;
    private String memberGender;
    private String memberBirthday;
    private String memberZipcode;
    private String memberAddress;
    private String memberAddressDetail;
    private String memberEnrollDate;
    private String memberEnrollType;
    private String memberGoal;
    private String memberInterest;
    private String memberVisitPath;
    private String memberWorkoutHour;
    private String memberRfCard;
    private String memberSmsAgreement;
    private String memberTmAgreement;
    private String memberSelfAgreement;
    private String memberType;
    private String memberMemo;
    private String memberAge;
    private long gymId;
}
