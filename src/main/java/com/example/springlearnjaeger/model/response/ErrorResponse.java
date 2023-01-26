package com.example.springlearnjaeger.model.response;

public class ErrorResponse extends Response{

    public ErrorResponse(String message) {
        super(false, message);
    }
}
