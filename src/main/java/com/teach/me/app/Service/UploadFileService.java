package com.teach.me.app.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadFileService {

        String saveFile(MultipartFile file);
}
