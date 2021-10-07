package com.teach.me.app.Repository;

import com.teach.me.app.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    public List<Question> findAllByTestTestId(int testId);
}
