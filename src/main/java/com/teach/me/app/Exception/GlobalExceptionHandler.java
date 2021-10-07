package com.teach.me.app.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ErrorResponse errorResponse;

    @ExceptionHandler(QuestionNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleQuestionNotFoundException(QuestionNotFoundException exception) {
        errorResponse.setErrorMessage("Question with given id does not exist");
        errorResponse.setErrorCode("500");
        errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleResponseException() {
        errorResponse.setErrorMessage("Response with given id is not found");
        errorResponse.setErrorCode("500");
        errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleSubjectException() {
        errorResponse.setErrorMessage("Subject with given subjectId is not found");
        errorResponse.setErrorCode("500");
        errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(TestNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleTestException() {
        errorResponse.setErrorMessage("Test with given id is not found");
        errorResponse.setErrorCode("500");
        errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUserException() {
        errorResponse.setErrorMessage("User with given id is not found");
        errorResponse.setErrorCode("500");
        errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return errorResponse;
    }
}
