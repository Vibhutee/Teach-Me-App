package com.teach.me.app.Service;

import com.teach.me.app.Model.TestResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestResultService {

    /**
     * @param userId
     * @return
     */
    public List<TestResult> findAllTestResultsByUserId(int userId);
}
