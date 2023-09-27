package com.lcwd.electronic.store.services.implementations;

import com.lcwd.electronic.store.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadImage(MultipartFile file, String path) throws IOException {
        String originalFilename= file.getOriginalFilename();
        logger.info("File name : ",originalFilename);
        String filename = UUID.randomUUID().toString();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filenamewithExtension = filename+extension;
        String fullPathWithFileName= path+filenamewithExtension;

        if (extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpg")|| extension.equalsIgnoreCase(".jpeg")){
            // file save
            File folder = new File(path);
            if(!folder.exists())
            {
                //create folder
                folder.mkdirs();
            }

            //upload

          Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
            return filenamewithExtension;

        }else{
            throw new RuntimeException("File with this "+ extension + " not allowed.");
        }

    }

    @Override
    public InputStream getResource(String path, String name) throws FileNotFoundException {

        String fullPath = path+File.separator+name;
        InputStream inputStream= new FileInputStream(fullPath);
        return inputStream;
    }
}
