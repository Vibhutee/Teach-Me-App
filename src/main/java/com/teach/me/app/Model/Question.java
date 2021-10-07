package com.teach.me.app.Model;

import com.teach.me.app.Enum.Difficulty;
import com.teach.me.app.Enum.Option;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @NotNull
    private String description;

    @NotNull
    private Option answer;

    @NotNull
    private String option_1;
    @NotNull
    private String option_2;
    private String option_3;
    private String option_4;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;
    @NotNull
    private Difficulty difficulty;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Option getAnswer() {
        return answer;
    }

    public void setAnswer(Option answer) {
        this.answer = answer;
    }

    public String getOption_1() {
        return option_1;
    }

    public void setOption_1(String option_1) {
        this.option_1 = option_1;
    }

    public String getOption_2() {
        return option_2;
    }

    public void setOption_2(String option_2) {
        this.option_2 = option_2;
    }

    public String getOption_3() {
        return option_3;
    }

    public void setOption_3(String option_3) {
        this.option_3 = option_3;
    }

    public String getOption_4() {
        return option_4;
    }

    public void setOption_4(String option_4) {
        this.option_4 = option_4;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                ", answer=" + answer +
                ", option_1='" + option_1 + '\'' +
                ", option_2='" + option_2 + '\'' +
                ", option_3='" + option_3 + '\'' +
                ", option_4='" + option_4 + '\'' +
                ", test=" + test +
                ", difficulty=" + difficulty +
                '}';
    }
}
