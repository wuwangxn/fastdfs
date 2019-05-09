package com.xning.fastdfs.user.controller;

import com.xning.fastdfs.fastdfs.DfsFileService;
import com.xning.fastdfs.user.entity.User;
import com.xning.fastdfs.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private DfsFileService fileService;

    @GetMapping(value = "/get/{id}")
    public User get(@Validated Long id) {
        User user = service.get(id);
        return user;
    }

    @PostMapping(value = "save")
    public void save(@RequestBody User user, @RequestParam("file") MultipartFile file) {
        String path = "";
//        if(!file.isEmpty()){
//            try {
//                path = fileService.saveFile(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        if (path != null && path != "") user.setHeardPic(path);
        service.save(user);
    }

    @RequestMapping(value = "upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String path = "";
        try {
            path = fileService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "learn.xningf.com" + path;
    }

    @RequestMapping(value = "deleteFile")
    public boolean deleteFile(@RequestParam("path") String path) {
        return fileService.deleteFile(path);
    }


}
