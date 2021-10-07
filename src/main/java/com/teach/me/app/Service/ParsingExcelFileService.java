package com.teach.me.app.Service;

import com.teach.me.app.Model.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ParsingExcelFileService {

    void readFile(String filePath, Test test ) throws IOException, InvalidFormatException;
}
