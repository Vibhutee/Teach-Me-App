package com.teach.me.app.Exception;

public class SubjectNotFoundException extends Throwable {

    /**
     * @param message Exception message to be thrown.
     */
    private String message;

    public SubjectNotFoundException() {

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
