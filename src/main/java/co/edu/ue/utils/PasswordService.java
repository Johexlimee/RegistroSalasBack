package co.edu.ue.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final PasswordEncoder passwordEncoder;

    // Constructor para inicializar el codificador
    public PasswordService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Codifica una contraseña en texto plano.
     *
     * @param rawPassword Contraseña en texto plano.
     * @return Contraseña codificada.
     */
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Verifica si una contraseña en texto plano coincide con una codificada.
     *
     * @param rawPassword Contraseña en texto plano.
     * @param encodedPassword Contraseña codificada almacenada.
     * @return true si coinciden, false de lo contrario.
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}



