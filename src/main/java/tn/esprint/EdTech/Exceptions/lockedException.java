package tn.esprint.EdTech.Exceptions;

import org.springframework.http.HttpStatus;

public class lockedException extends apiBaseException{
    public lockedException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getCodeState() {
        return HttpStatus.LOCKED;
    }
}
