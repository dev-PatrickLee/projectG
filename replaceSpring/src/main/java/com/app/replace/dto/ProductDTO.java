package com.app.replace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProductDTO {
    long id;
    String productName;
    int productExpireDates;
    int productPrice;
    long gymId;
    String gymName;
}
