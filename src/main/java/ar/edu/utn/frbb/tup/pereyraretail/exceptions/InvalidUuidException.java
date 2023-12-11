package ar.edu.utn.frbb.tup.pereyraretail.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidUuidException extends RuntimeException {
    public InvalidUuidException(String message, Throwable err) {
        super(message, err);
    }
    public InvalidUuidException(Throwable err) { super(err); }
    public InvalidUuidException(String message) {
        super(message);
    }
    public InvalidUuidException() {}
}

