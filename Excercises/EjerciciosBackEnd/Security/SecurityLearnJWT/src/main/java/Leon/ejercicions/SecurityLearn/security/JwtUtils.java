package Leon.ejercicions.SecurityLearn.security;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.keys.HmacKey;

public class JwtUtils {
    //secret y elementos basicos para generar el token
    private static final String NOMBRE_LLAVA = "miLLave";
    private static final String SECRETO ="clave-secreta";
    private static final String ALGORITMO_UTILIZADO = AlgorithmIdentifiers.HMAC_SHA256;
    private static final HmacKey = new HmacKey(SECRETO.getBytes().)
    private int tokenDuration = 3600000;

    //generar token
    public String generateToken(String userName, String role){
        return Jwts.builder
    }


    //validar token

    //validar vencimiento de token

    //obtener usuario de token

    //obtener rol desde el token

    //obtener las claims del token
}
