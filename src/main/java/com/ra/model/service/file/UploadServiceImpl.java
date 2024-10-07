package com.ra.model.service.file;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class UploadServiceImpl implements UploadService{
    @Override
    public String upload(MultipartFile image){
        String uploadPath = "D:\\Luannv\\JAVAFT-240617\\session13\\src\\main\\webapp\\uploads";
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
        return fileImage;
    }

}
