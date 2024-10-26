package ar.edu.utn.bda.JWTDemo.controllers;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String message) {
        super(message);
    }
}
