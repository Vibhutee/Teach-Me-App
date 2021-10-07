package com.teach.me.app.Controller;

import com.teach.me.app.DTO.TestDTO;
import com.teach.me.app.Exception.SubjectNotFoundException;
import com.teach.me.app.Exception.TestNotFoundException;
import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.Subject;
import com.teach.me.app.Model.Test;
import com.teach.me.app.Model.User;
import com.teach.me.app.Service.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ParsingExcelFileService parsingExcelFileService;

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private UserService userService;

    @PostMapping("/test/insert")
    private void insertTest(@RequestParam("file") MultipartFile file, @RequestParam("testName") String name, @RequestParam("userId") int userId, @RequestParam("subjectId") int subjectId, @RequestParam("cheatSheet") String cheatSheet,@RequestParam("totalQuestion") int totalQuestion,@RequestParam("totalTime") long totalTime,@RequestParam("references") String references) throws IOException, InvalidFormatException, SubjectNotFoundException, UserNotFoundException {
        Test newTest = new Test();
        Subject subject = subjectService.getSubjectById(subjectId);
        User user = userService.getUserById(userId);
        newTest.setTotalTime(totalTime);
        newTest.setNumberOfQuest(totalQuestion);
        newTest.setName(name);
        newTest.setCheatSheet(cheatSheet);
        newTest.setReference(references);
        newTest.setSubject(subject);
        newTest.setUser(user);
        Test test = testService.insertTest(newTest);
        String fileName = uploadFileService.saveFile(file);
        parsingExcelFileService.readFile(fileName, test);
        System.out.println(test);
        //Test newTest = testService.insertTest(test);
        // String fileName = uploadFileService.saveFile(file);
        // parsingExcelFileService.readFile(fileName,newTest);
    }
    @GetMapping("/test/all")
    private List<Test> getAllTests(){
        List<Test> testList = new ArrayList<Test>();
        testList = testService.getAllTests();
        return testList;
    }
    @GetMapping("/test/{testId}")
    private Test getTestByTestId(@PathVariable int testId) throws TestNotFoundException {
         return testService.getTestById(testId);
    }

    @GetMapping("/subject/test/{subjectId}")
    private TestDTO getTestsBySubjectId(@PathVariable int subjectId) throws SubjectNotFoundException {
        TestDTO testDTO = new TestDTO();
        testDTO = testService.getTestsBySubjectId(subjectId);
        return testDTO;

    }

}
