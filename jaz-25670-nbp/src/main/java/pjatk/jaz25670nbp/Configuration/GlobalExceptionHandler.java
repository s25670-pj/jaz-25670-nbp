package pjatk.jaz25670nbp.Configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    //40x
    @ExceptionHandler
    public ResponseEntity<String> handleRuntimeException(RuntimeException e)
    {
        if(e instanceof NullPointerException)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request | Error:" + e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono wpisów | Error: " + e.getLocalizedMessage());
    }
    //50x
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ResponseEntity<String> handleInternalServerError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server is down | Error:" + ex.getLocalizedMessage());
    }
}
