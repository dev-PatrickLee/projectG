package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FileVO {
    private long id;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private String fileType;
    private long fileSize;
    private long memberId;
}
