package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Exception.SubjectNotFoundException;
import com.teach.me.app.Model.Subject;
import com.teach.me.app.Repository.SubjectRepository;
import com.teach.me.app.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    /**
     * @param subject
     * @return
     */
    @Override
    public Subject insertSubject(Subject subject) {
        List<Subject> allSubjects = subjectRepository.findAll();
        for (Subject s : allSubjects) {
            if (s.getName().equals(subject.getName()))
                return null;
        }
        return subjectRepository.save(subject);
    }

    /**
     * @return
     */
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    /**
     * @param subjectId
     * @return
     */
    @Override
    public Subject getSubjectById(int subjectId) throws SubjectNotFoundException {
        return subjectRepository.findById(subjectId).orElseThrow(SubjectNotFoundException::new);
    }
}
