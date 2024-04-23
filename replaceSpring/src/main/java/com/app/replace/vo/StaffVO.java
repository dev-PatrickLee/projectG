package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StaffVO {
    private long id;
    private String staffTeam;
    private String staffPosition;
    private String staffRank;
    private String staffCaptain;
    private String staffBankInfo;
    private String staffBankAccountOwner;
    private String staffBankAccountNumber;
    private String staffExtraInfo;
    private String staffStartDate;
    private String staffEndDate;
    private String staffAssigned;
    private String staffAssignedTm;
    private String staffStrategyNote;
    private String staffGxInstructor;
    private String staffProfileUnveil;
    private String staffPurchaseAlterAuthority;
    private String staffIsReaderOnly;
    private String staffMedicalHistory;
    private String staffIntro;
    private long memberId;

}
