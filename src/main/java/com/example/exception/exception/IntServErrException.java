package com.example.exception.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
 import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)             //это ошибка 500
public class IntServErrException extends InternalError {         //класс IntServErrException наследует InternalError
}
