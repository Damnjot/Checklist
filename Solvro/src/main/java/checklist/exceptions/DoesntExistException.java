package checklist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoesntExistException extends RuntimeException{
    public DoesntExistException(String msg) {
        super(msg);
    }
}
