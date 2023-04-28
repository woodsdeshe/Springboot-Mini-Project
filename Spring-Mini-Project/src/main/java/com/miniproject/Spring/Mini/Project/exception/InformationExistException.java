package com.miniproject.Spring.Mini.Project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The response annotation lets us know that the exception will result in a http response of conflict.
 * The conflict value lets us know that the users request can't be carried out because there is a conflict with the CRUD operations of the API
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException{
    public InformationExistException(String message) {
        super(message);
    }
}
