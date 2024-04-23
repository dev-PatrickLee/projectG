package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DocumentVO {
    private long id;
    private String documentDate;
    private String documentGoal;
    private String documentBodyInfo;
    private String documentPainInfo;
    private int documentWeight;
    private int documentMuscle;
    private int documentFatKg;
    private int documentFatPercent;
    private int documentBodyScore;
    private long memberId;
}
