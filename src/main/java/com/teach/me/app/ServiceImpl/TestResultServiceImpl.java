package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Model.TestResult;
import com.teach.me.app.Repository.TestResultRepository;
import com.teach.me.app.Service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    private TestResultRepository testResultRepository;
    /**
     * @param userId
     * @return
     */
    @Override
    public List<TestResult> findAllTestResultsByUserId(int userId) {
        return testResultRepository.getTestResultsByUserEquals(userId);
    }
}
