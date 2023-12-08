package ar.edu.utn.frbb.tup.pereyraretail.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message, Throwable err) {
        super(message, err);
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
