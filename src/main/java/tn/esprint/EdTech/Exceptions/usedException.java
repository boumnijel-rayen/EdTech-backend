package tn.esprint.EdTech.Exceptions;

import org.springframework.http.HttpStatus;

public class usedException extends apiBaseException{
    public usedException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getCodeState() {
        return HttpStatus.IM_USED;
    }
}
