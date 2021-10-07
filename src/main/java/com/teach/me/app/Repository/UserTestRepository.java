package com.teach.me.app.Repository;

import com.teach.me.app.Model.Test;
import com.teach.me.app.Model.User;
import com.teach.me.app.Model.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTestRepository extends JpaRepository<UserTest, Integer> {

    public List<UserTest> getByUserUserId(int userId);

    //TODO Checking if a user has given the test.
    //TODO List of users by testId

    public Optional<UserTest> getByUserUserIdAndTestTestId(int userId, int testId);

    public List<UserTest> getUserByTestTestId(int testId);

}
