package com.teach.me.app.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "test")
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column( length = 100000 )
    private String cheatSheet;

    @NotNull
    private long totalTime;
    @NotNull
    private int numberOfQuest;
    private String reference;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCheatSheet() {
        return cheatSheet;
    }

    public void setCheatSheet(String cheatSheet) {
        this.cheatSheet = cheatSheet;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public int getNumberOfQuest() {
        return numberOfQuest;
    }

    public void setNumberOfQuest(int numberOfQuest) {
        this.numberOfQuest = numberOfQuest;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", user=" + user +
                ", cheat_sheet='" + cheatSheet + '\'' +
                ", totalTime=" + totalTime +
                ", numberOfQuest=" + numberOfQuest +
                ", reference='" + reference + '\'' +
                '}';
    }
}
