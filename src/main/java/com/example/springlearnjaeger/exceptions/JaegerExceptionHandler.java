package com.example.springlearnjaeger.exceptions;

import com.example.springlearnjaeger.model.response.ErrorResponse;
import com.example.springlearnjaeger.model.response.Response;
import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class JaegerExceptionHandler {


    private final JaegerTracer jaegerTracer;

    @Autowired
    public JaegerExceptionHandler(JaegerTracer jaegerTracer) {
        this.jaegerTracer = jaegerTracer;
    }



    @ExceptionHandler(value = { UserNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleUserNotFoundException(Exception ex) {
        generateSpan("handleUserNotFoundExceptions",ex);
        return new ErrorResponse(ex.getMessage());
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

    private void generateSpan(String operationName, Exception ex){
        // TODO: set current auth user
        Span span = jaegerTracer.buildSpan(operationName).start();
        span.setTag("error",true);
        Map<String,Object> logs = new HashMap<>();
        logs.put("message", ex.getMessage());
        logs.put("errorType", ex.getClass());
        span.log(logs);
        span.finish();
    }
}
