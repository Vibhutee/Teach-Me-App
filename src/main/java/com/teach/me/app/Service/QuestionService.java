package com.teach.me.app.Service;

import com.teach.me.app.Exception.QuestionNotFoundException;
import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {

    /**
     *
     * @param question
     */
     void insertQuestion(Question question);

    /**
     *
     * @return
     */
     List<Question> getAllQuestions();

    /**
     *
     * @param id
     * @return
     */
     Question getQuestionById(int id) throws QuestionNotFoundException;

    /**
     *
     * @param testId
     * @return
     */
     List<Question> getAllQuestionByTestId(int testId);

    /**
     *
     * @param testId
     * @param userId
     * @return
     */
     Question getRandomQuestion(int testId, int userId) throws UserNotFoundException;


}
