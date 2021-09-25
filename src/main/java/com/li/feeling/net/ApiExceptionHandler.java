package com.li.feeling.net;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 用于异常处理
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(FeelingException.class)
    public FeelingResponse handleException(HttpServletRequest req, FeelingException e) {
        return FeelingResponse.fail(e.mErrorCode, e.mErrorMessage);
    }

}
