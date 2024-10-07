package com.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @Autowired
    private ServletContext servletContext;
    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }
    @PostMapping("/upload")
    public String handlerUpload(@RequestParam("image") MultipartFile image, Model model){
        // xư l upload
        // String uploadPath = servletContext.getRealPath("/uploads");
        String uploadPath = "D:\\Luannv\\JAVAFT-240617\\session13\\src\\main\\webapp\\uploads";
        System.out.println(uploadPath);
        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdir();
        }
        // lấy tên file
        String fileImage = image.getOriginalFilename();
        //System.out.println(fileImage);
        // copy file upload lên gửi vo thư mục uploads
        try {
            FileCopyUtils.copy(image.getBytes(),new File(uploadPath+File.separator+fileImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("image",fileImage);
        return "home";
    }
}
