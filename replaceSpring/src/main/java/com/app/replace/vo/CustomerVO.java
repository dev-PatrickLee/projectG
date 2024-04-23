package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CustomerVO {
    private long id;
    private String memberGender;
    private String memberBirthday;
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
    private long memberId;
}
