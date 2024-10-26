package ar.edu.utn.bda.JWTDemo.controllers.response;

import lombok.Value;

import java.util.Map;

@Value
public class RandomResponseDTO {
    Long valorAleatorio;
    Map<String, Object> detallesToken;
}
