package com.lcwd.electronic.store.exceptions;

import com.lcwd.electronic.store.dtos.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handler resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
    {
       ApiResponseMessage response= ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    //MethodArgumentNOtValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
       List<ObjectError> allError= ex.getBindingResult().getAllErrors();
       Map<String,Object> response = new HashMap<>();
       allError.stream().forEach(objectError -> {
          String message= objectError.getDefaultMessage();
          String field= ((FieldError)objectError).getField();
           response.put(field,message);
       });
       return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    // handle bad api exception
    @ExceptionHandler(BadApiRequest.class)
    public ResponseEntity<ApiResponseMessage> handleBadApiRequest(BadApiRequest ex)
    {
        ApiResponseMessage response= ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(false).build();
        return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
