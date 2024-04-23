package com.app.replace.controller;

import com.app.replace.dao.FileDAO;
import com.app.replace.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/file/*")
public class FileController {
    private final String projectPath = System.getProperty("user.dir").replace("\\","/");
    private final String imageFilePath = "/src/main/resources/static/image";
    private final FileDAO fileDAO;

    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("uploadFile")MultipartFile uploadFile, @RequestParam("memberId")long memberId) throws IOException {
        FileVO fileVO = new FileVO();
        String path = projectPath + imageFilePath + "/memberProfile";// + getPath();
        String uuid = UUID.randomUUID().toString();
        String type = uploadFile.getContentType().split("/")[1];
        String fileName = memberId+"";

        File file = new File(path,uuid + "_" + fileName + "."+type);
        if (!file.exists()){
            file.mkdirs();
        }

        uploadFile.transferTo(file);

        String thumbName = "thumb_" + fileName;

        Thumbnailator.createThumbnail(file,new File(path,uuid + "_" + thumbName + "."+type),300,300);
        fileVO.setFileName(thumbName);
        fileVO.setFilePath(imageFilePath + "/memberProfile");
        fileVO.setFileUuid(uuid);
        fileVO.setFileType(type);
        fileVO.setMemberId(memberId);

        fileDAO.insert(fileVO);

        if (file.delete()) {
//            log.info("file saved : {}", path + uuid + "_" + thumbName + "." + type);
            return uuid + "save success";
        }else{
            return uuid + " save failed";
        }
    }

    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    @GetMapping("display")
    @ResponseBody
    public byte[] display(String memberId) throws IOException{


        Optional<FileVO> fileVO = fileDAO.select(Long.parseLong(memberId));
        if (fileVO.isPresent()){
//            log.info("file info : {}",fileVO.get().toString());
            return FileCopyUtils.copyToByteArray(new File(projectPath + fileVO.get().getFilePath()+"/" + fileVO.get().getFileUuid()+"_"+fileVO.get().getFileName() + "." + fileVO.get().getFileType()));
        }
        else {
            return FileCopyUtils.copyToByteArray(new File(projectPath + imageFilePath+"/" + "user_icon.png"));
        }



    }
}
