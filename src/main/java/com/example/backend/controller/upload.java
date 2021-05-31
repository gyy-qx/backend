package com.example.backend.controller;

import com.example.backend.service.FileUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class upload {
//    @Autowired
    FileUploadService fileUploadService;
    @PostMapping(value = "/upload")
    // @RequestParam中的file名应与前端的值保持一致
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        // replaceAll 用来替换windows中的\\ 为 /
        fileUploadService.upload(multipartFile).replaceAll("\\\\", "/");
        return multipartFile.getOriginalFilename();
    }

    @PostMapping(value = "/uploadCover")
    // @RequestParam中的file名应与前端的值保持一致
    public String uploadCover(@RequestParam("file") MultipartFile multipartFile) {
        // replaceAll 用来替换windows中的\\ 为 /
        fileUploadService.uploadCover(multipartFile).replaceAll("\\\\", "/");
        return multipartFile.getOriginalFilename();
    }

}
