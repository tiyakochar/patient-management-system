package com.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {


    private static  final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
   @ExceptionHandler(PatientNotFound.class)
   public String handlePatientNotFoundException(PatientNotFound ex) {
       return ex.getMessage();

   }
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> methodargumentnotvalidexception(MethodArgumentNotValidException ex){
       logger.warn("Error occured while validating the request body");
      Map<String ,String> erroMap=new HashMap<>();
      ex.getBindingResult().getFieldErrors().forEach((fieldError )->{erroMap.put(fieldError.getField(),fieldError.getDefaultMessage());});
      return ResponseEntity.badRequest().body(erroMap);
   }

   @ExceptionHandler(PatientAlreadyExistByEmail.class)
   public ResponseEntity<String> handlePatientAlreadyExistByEmail(PatientAlreadyExistByEmail ex) {
       logger.warn("Patient Already Exist By Email {}",ex.getMessage());
       return ResponseEntity.badRequest().body(ex.getMessage());

   }

   @ExceptionHandler(IllegalArgumentException.class)
   public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex){
       logger.warn("Request argument should be checked ");
       return ResponseEntity.badRequest().body("Request arguments are invalid:");
   }


}
