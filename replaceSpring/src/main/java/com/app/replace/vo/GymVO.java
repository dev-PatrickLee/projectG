package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class GymVO {
    private long id;
    private String gymName;
    private String gymZipcode;
    private String gymAddress;
    private String gymAddressDetail;
    private String gymPhone;
}