package com.teach.me.app.ServiceImpl;

import com.teach.me.app.DTO.TestDTO;
import com.teach.me.app.Exception.SubjectNotFoundException;
import com.teach.me.app.Exception.TestNotFoundException;
import com.teach.me.app.Model.Subject;
import com.teach.me.app.Model.Test;
import com.teach.me.app.Repository.TestRepository;
import com.teach.me.app.Service.SubjectService;
import com.teach.me.app.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private SubjectService subjectService;
    /**
     * @param test
     */
    @Override
    public Test insertTest(Test test) {
        return testRepository.save(test);
    }

    /**
     * @return
     */
    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    /**
     * @param testId
     * @return
     */
    @Override
    public Test getTestById(int testId) throws TestNotFoundException {
        return testRepository.findById(testId).orElseThrow(TestNotFoundException::new);
    }

    /**
     *
     * @param subjectId
     * @return
     */
    @Override
    public TestDTO getTestsBySubjectId(int subjectId) throws SubjectNotFoundException {
        List<Test> tests = new ArrayList<Test>();
        tests = testRepository.getAllBySubject_SubjectId(subjectId);
        Subject subject = subjectService.getSubjectById(subjectId);
        TestDTO testDTO = new TestDTO();
        testDTO.setSubjectName(subject.getName());
        testDTO.setSubjectId(subjectId);
        testDTO.setTestList(tests);
        return testDTO;
    }
}
