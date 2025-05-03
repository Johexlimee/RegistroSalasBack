package co.edu.ue.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Clave secreta definida en Tools
    private static final String SECRET_KEY_STRING = Tools.CLAVE;
    private static final Key SECRET_KEY = generateSecretKey(SECRET_KEY_STRING);

    // Tiempo de expiración del token en milisegundos (10 horas)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;

    /**
     * Genera una clave secreta a partir de una cadena codificada en Base64.
     * 
     * @param secret Cadena secreta en formato Base64.
     * @return Clave secreta como objeto Key.
     */
    private static Key generateSecretKey(String secret) {
        try {
            byte[] keyBytes = Decoders.BASE64.decode(secret);
            return Keys.hmacShaKeyFor(keyBytes);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                "Clave secreta inválida: asegúrate de que esté codificada en Base64 y tenga al menos 256 bits.", e
            );
        }
    }

    /**
     * Genera un token JWT con el correo del usuario como subject y rol como claim adicional.
     * 
     * @param correo Correo del usuario.
     * @param rol El rol del usuario (por ejemplo, "ADMINISTRADOR" o "PROFESOR").
     * @return Token JWT generado.
     */
    public String generarToken(String correo, String rol) {
        return Jwts.builder()
                .setSubject(correo)  // Asignamos el correo como subject
                .claim("rol", rol)   // Añadimos el rol como claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Valida si un token es válido y no ha expirado.
     * 
     * @param token Token JWT a validar.
     * @return true si el token es válido, false en caso contrario.
     */
    public boolean validarToken(String token) {
        try {
            obtenerClaims(token); // Si no lanza excepción, el token es válido
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Extrae los claims de un token JWT.
     * 
     * @param token Token JWT.
     * @return Claims contenidos en el token.
     * @throws Exception Si el token es inválido o ha expirado.
     */
    public Claims obtenerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Obtiene el correo del usuario desde el token JWT.
     * 
     * @param token Token JWT.
     * @return Correo del usuario (subject del token).
     */
    public String obtenerCorreo(String token) {
        return obtenerClaims(token).getSubject();
    }

    /**
     * Obtiene el rol del usuario desde el token JWT.
     * 
     * @param token Token JWT.
     * @return El rol del usuario.
     */
    public String obtenerRol(String token) {
        return (String) obtenerClaims(token).get("rol");
    }
}
