package checklist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class DoneCorrectlyException extends RuntimeException{
    public DoneCorrectlyException(String msg) {
        super(msg);
    }
}