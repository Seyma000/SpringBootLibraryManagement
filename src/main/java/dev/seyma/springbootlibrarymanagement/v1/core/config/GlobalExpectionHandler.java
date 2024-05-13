package dev.seyma.springbootlibrarymanagement.v1.core.config;

import dev.seyma.springbootlibrarymanagement.v1.core.result.ResultData;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.transform.Result;
import java.util.List;

@ControllerAdvice
public class GlobalExpectionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidtionErrors(MethodArgumentNotValidException e) {
        List<String> errorList = e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        return new ResponseEntity<>(ResultHelper.ERROR(errorList), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException() {
        return new ResponseEntity<>(ResultHelper.NOT_FOUND(),HttpStatus.NOT_FOUND);
    }

}