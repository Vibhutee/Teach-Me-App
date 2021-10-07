package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Exception.QuestionNotFoundException;
import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.Question;
import com.teach.me.app.Model.Response;
import com.teach.me.app.Repository.QuestionRepository;
import com.teach.me.app.Service.QuestionService;
import com.teach.me.app.Service.ResponseService;
import com.teach.me.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private UserService userService;
    /**
     * @param question
     */
    @Override
    public void insertQuestion(Question question) {
            questionRepository.save(question);
    }

    /**
     * @return
     */
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Question getQuestionById(int id) throws QuestionNotFoundException {
        return questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    @Override
    public List<Question> getAllQuestionByTestId(int testId) {
        return questionRepository.findAllByTestTestId(testId);
    }

    /**
     * @param testId
     * @param userId
     * @return
     */
    @Override
    public Question getRandomQuestion(int testId, int userId) throws UserNotFoundException {
        Question question = null;
        List<Question> questionList = new ArrayList<Question>();
        questionList = getAllQuestionByTestId(testId);
        if (!questionList.isEmpty()) {
            Random random = new Random();
            int questionIndex = random.nextInt(questionList.size());
            if (!responseService.isQuestionAttempted(userId, questionList.get(questionIndex).getQuestionId())) {
                question = questionList.get(questionIndex);
                Response response = new Response();
                response.setQuestion(question);
                response.setUser(userService.getUserById(userId));
                response.setTest(questionList.get(0).getTest());
                response.setStatus("IN PROGRESS");
                responseService.insertResponse(response);
            }
        }
        return question;
    }
}
