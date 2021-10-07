package com.teach.me.app.Repository;

import com.teach.me.app.Model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Integer> {

    List<TestResult> getTestResultsByUserEquals(int userId);
}
