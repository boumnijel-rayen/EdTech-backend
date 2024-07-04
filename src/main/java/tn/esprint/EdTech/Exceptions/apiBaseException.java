package tn.esprint.EdTech.Exceptions;

import org.springframework.http.HttpStatus;

public abstract class apiBaseException extends RuntimeException{
    public apiBaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getCodeState();
}
