package com.teach.me.app.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "test_result")
public class TestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testResultId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @NotNull
    private long correctQuestions;
    @NotNull
    private long totalQuestions;

    public int getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(int testResultId) {
        this.testResultId = testResultId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public long getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(long correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    public long getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(long totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    @Override
    public String toString() {
        return "Test_Result{" +
                "testResultId=" + testResultId +
                ", user=" + user +
                ", test=" + test +
                ", correctQuestions=" + correctQuestions +
                ", totalQuestions=" + totalQuestions +
                '}';
    }
}
