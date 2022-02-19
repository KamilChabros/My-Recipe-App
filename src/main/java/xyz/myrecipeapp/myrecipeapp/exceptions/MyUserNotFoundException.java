package xyz.myrecipeapp.myrecipeapp.exceptions;

public class MyUserNotFoundException extends RuntimeException {
    public MyUserNotFoundException(String message) {
        super(message);
    }
}
