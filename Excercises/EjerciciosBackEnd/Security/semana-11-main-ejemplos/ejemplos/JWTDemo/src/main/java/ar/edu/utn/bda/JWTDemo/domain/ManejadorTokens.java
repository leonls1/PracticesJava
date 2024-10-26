package ar.edu.utn.bda.JWTDemo.domain;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.*;
import org.jose4j.jwt.consumer.*;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;

import java.nio.charset.StandardCharsets;
import java.util.Map;


public class ManejadorTokens {

    private final String nombre;
    private final String algoritmo;
    private final String secreto;

    private final long segundosValidez;
    private final HmacKey hmacKey;

    public ManejadorTokens(String nombreLlave, String algoritmo, String secreto, long validezSegundos) {
        this.nombre = nombreLlave;
        this.algoritmo = algoritmo;
        this.secreto = secreto;
        this.segundosValidez = validezSegundos;
        this.hmacKey = new HmacKey(this.secreto.getBytes(StandardCharsets.UTF_8));
    }

    public String crearToken(String usuario) throws JoseException {

        // Fecha/hora actual
        var issuedAt = NumericDate.now();
        // Copia de la Fecha/Hora actual
        var expiresAt = NumericDate.fromSeconds(issuedAt.getValue());
        // La expiración será segundosValidez luego de la emisión
        expiresAt.addSeconds(segundosValidez);

        // Creación de los claims. Aquí se pueden agregar claims adicionales.
        JwtClaims claims = new JwtClaims();
        claims.setSubject(usuario);
        claims.setIssuedAt(issuedAt);
        claims.setExpirationTime(expiresAt);

        // El token va a incluír una firma
        JsonWebSignature jws = new JsonWebSignature();
        // La firma se realiza a partir de una llave y aplicando un cierto algoritmo
        jws.setKeyIdHeaderValue(nombre);
        jws.setKey(hmacKey);
        jws.setAlgorithmHeaderValue(algoritmo);

        // Hay que setear los claims creados anteriormente
        jws.setPayload(claims.toJson());

        // Finalmente, hay que recordar que para que sea transmitido debe serializarse en su forma compacta
        return jws.getCompactSerialization();
    }

    public Map<String, Object> verificarToken(String token) throws InvalidJwtException {

        // jose4j utiliza la clase JwtConsumer para realizar la validación
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime() // Se requiere que tenga el claim "exp"
                .setRequireSubject() // Se requiere que tenga el claim "sub"
                .setVerificationKey(hmacKey) // Necesita la clave para poder verificar la firma
                .setJwsAlgorithmConstraints(
                        AlgorithmConstraints.ConstraintType.PERMIT, algoritmo
                ) // Que controle que el header contenga al algoritmo esperado
                .build(); // create the JwtConsumer instance

        // Una vez construído el consumidor, se lo procesa. Ante un problema al validarlo,
        // se arroja la excepción InvalidJwtException. La excepción contiene información al
        // respecto de qué validación falló (si la firma o si expiró, etc.)
        JwtClaims claims = jwtConsumer.processToClaims(token);

        // Retorno los claims como una cadena JSON
        return claims.getClaimsMap();
    }

}
