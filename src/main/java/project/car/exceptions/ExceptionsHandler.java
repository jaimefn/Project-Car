package project.car.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.ws.rs.NotFoundException;
import java.io.IOException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({IOException.class})
    public ResponseEntity NotFoundException(IOException e){
        return ResponseEntity.notFound().build();
    }


}
