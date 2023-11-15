package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    long id;
    String memberName;
    String memberEmail;
    String memberPassword;
    String memberPhone;
    String memberGender;
    String memberBirthday;
    String memberZipcode;
    String memberAddress;
    String memberAddressDetail;
    String memberEnrollDate;
    String memberEnrollType;
    String memberGoal;
    String memberInterest;
    String memberVisitPath;
    String memberWorkoutHour;
    String memberRfCard;
    String memberSmsAgreement;
    String memberTmAgreement;
    String memberSelfAgreement;
    String memberType;
    String memberMemo;
    String memberAge;
}
