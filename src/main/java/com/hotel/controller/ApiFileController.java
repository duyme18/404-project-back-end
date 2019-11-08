package com.hotel.controller;

import com.hotel.model.FileForm;
import com.hotel.model.Home;
import com.hotel.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
public class ApiFileController {
    @Autowired
    private HomeService homeService;

    @Autowired
    Environment env;

    @PostMapping(value = "/api/file/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<Void> uploadFile(@ModelAttribute FileForm fileForm, BindingResult result, @PathVariable Long id) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MultipartFile multipartFile = fileForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(fileForm.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Home home = homeService.findById(id);
        home.setImage(fileName);
        homeService.save(home);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
