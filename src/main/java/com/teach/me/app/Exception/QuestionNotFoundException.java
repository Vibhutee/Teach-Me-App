package com.teach.me.app.Exception;

public class QuestionNotFoundException extends Throwable {

    /**
     * @param message Exception message to be thrown.
     */
    private String message;

    public QuestionNotFoundException() {

        this.message = message;
    }

    /**
     * @return the error message to the service.
     */
    @Override
    public String getMessage() {
        return message;
    }
}
