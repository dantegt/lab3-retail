package ar.edu.utn.frbb.tup.pereyraretail.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUuidException extends Exception {
    public InvalidUuidException(String message, Throwable err) {
        super(message, err);
    }

    public InvalidUuidException(String message) {
        super(message);
    }
}
