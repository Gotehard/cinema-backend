package pl.macstr.cinema.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFountException extends RuntimeException {
    public RecordNotFountException(String message) {
        super(message);
    }
}
