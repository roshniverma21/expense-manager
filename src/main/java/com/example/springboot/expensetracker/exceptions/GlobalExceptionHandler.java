package com.example.springboot.expensetracker.exceptions;

import com.example.springboot.expensetracker.entity.ErrorObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorObject eObject = new ErrorObject();
        eObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        eObject.setMessage(ex.getMessage());
        eObject.setTimeStamp(new Date());
        return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        ErrorObject eObject = new ErrorObject();
        eObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
        eObject.setMessage(ex.getMessage());
        eObject.setTimeStamp(new Date());
        return new ResponseEntity<ErrorObject>(eObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request) {
        ErrorObject eObject = new ErrorObject();
        eObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        eObject.setMessage(ex.getMessage());
        eObject.setTimeStamp(new Date());
        return new ResponseEntity<ErrorObject>(eObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("statusCode", HttpStatus.BAD_REQUEST.value());

        //Get all errors using stream and lambda function
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("messages", errors);

        body.put("timestamp", new Date());

        return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);

    }
}
