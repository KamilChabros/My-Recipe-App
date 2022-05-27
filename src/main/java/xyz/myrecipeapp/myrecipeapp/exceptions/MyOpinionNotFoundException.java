package xyz.myrecipeapp.myrecipeapp.exceptions;

import xyz.myrecipeapp.myrecipeapp.model.Opinion;

public class MyOpinionNotFoundException extends RuntimeException {

    public MyOpinionNotFoundException(String message) {
        super(message);
    }
}
