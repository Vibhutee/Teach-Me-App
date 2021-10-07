package com.teach.me.app.Controller;

import com.teach.me.app.Exception.TestNotFoundException;
import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.Test;
import com.teach.me.app.Model.User;
import com.teach.me.app.Service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserTestController {
    @Autowired
    private UserTestService userTestService;

    @GetMapping("/test/students/{testId}")
    private List<User> getStudentByTestId(@PathVariable int testId){
        List<User> user = new ArrayList<User>();
        user = userTestService.getStudentByTestId(testId);
        return user;
    }

    @GetMapping("/students/test/{userId}")
    private List<Test> getTestByStudent(@PathVariable int userId){
        List<Test> testList = new ArrayList<Test>();
        testList = userTestService.getAllTestsbyUserId(userId);
        return testList;
    }

    @GetMapping("/students/test/{testId}/{userId}")
    private boolean isTestAttempted(@PathVariable int testId, @PathVariable int userId){
        return userTestService.isTestAttempted(userId, testId);
    }

    @GetMapping("/userTest/insert/{userId}/{testId}")
    private void insertUserTest(@PathVariable int userId, @PathVariable int testId) throws TestNotFoundException, UserNotFoundException {
        userTestService.insertUserTest(userId, testId);
    }



}
