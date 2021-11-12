package com.example.exception.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)        // это ошибка 404
//@ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)

public class NotFoundRuntimeException extends RuntimeException {     //класс NotFoundRuntimeException наследует RuntimeException

}
//Internal Server Error