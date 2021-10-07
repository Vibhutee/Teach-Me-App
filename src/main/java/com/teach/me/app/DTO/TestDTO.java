package com.teach.me.app.DTO;

import com.teach.me.app.Model.Test;

import java.util.List;

public class TestDTO {

    private int subjectId;

    private String subjectName;

    private List<Test> testList;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }
}
