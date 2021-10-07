package com.teach.me.app.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_test")
public class UserTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public int getUserTestId() {
        return userTestId;
    }

    public void setUserTestId(int userTestId) {
        this.userTestId = userTestId;
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

    @Override
    public String toString() {
        return "User_Test{" +
                "userTestId=" + userTestId +
                ", user=" + user +
                ", test=" + test +
                '}';
    }
}
