package ar.edu.utn.frbb.tup.pereyraretail.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ItemExistsException extends Exception {
    public ItemExistsException(String message, Throwable err) {
        super(message, err);
    }

    public ItemExistsException(String message) {
        super(message);
    }
}
