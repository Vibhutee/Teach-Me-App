package com.teach.me.app.Controller;

import com.teach.me.app.DTO.QuestionDTO;
import com.teach.me.app.Exception.QuestionNotFoundException;
import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.Question;
import com.teach.me.app.Service.QuestionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/question/insert")
    private void insertQuestion(@RequestBody Question question){
        questionService.insertQuestion(question);
    }
    @GetMapping("/question/all")
    private List getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/question/{id}")
    private Question getQuestionById(@PathVariable int id) throws QuestionNotFoundException {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/test/questions/{testId}")
    private List<Question> getQuestionsByTestId(@PathVariable int testId){
        return  questionService.getAllQuestionByTestId(testId);
    }

    @GetMapping("/takeTest/{testId}/{userId}")
    private QuestionDTO getRandomQuestion(@PathVariable int testId, @PathVariable int userId) throws UserNotFoundException {
        Question question = null;
        while (question == null) {
            question = questionService.getRandomQuestion(testId, userId);
        }
        Type questionType = new TypeToken<QuestionDTO>(){
        }.getType();
        return modelMapper.map(question, questionType);
    }

}
