package co.edu.ue.service;

import co.edu.ue.jpa.IUsuarioJpa;
import co.edu.ue.entity.Usuario;
import co.edu.ue.dao.UsuarioDao;
import co.edu.ue.entity.Acceso;
import co.edu.ue.jpa.IAccesoJpa;
import co.edu.ue.utils.JwtUtil;
import co.edu.ue.utils.PasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService  implements IUsuarioInterface{

    @Autowired
    private IUsuarioJpa usuarioRepository;
    
    @Autowired
    private UsuarioDao dao;

    @Autowired
    private IAccesoJpa accesoRepository; // Repositorio de Acceso para consultar si el usuario tiene acceso

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
	PasswordService passwordService;
    
    
    
    
    public Usuario registerUser(Usuario usuario) {
    	Usuario newUser = new Usuario();
	    newUser.setCorreo(usuario.getCorreo());
	    newUser.setContrasena(passwordService.encodePassword(usuario.getContrasena()));
	   
	    // Save the new user to the database
	    newUser = dao.registerUser(newUser);


	    // Return the created user
	    return newUser;
	}

    /**
     * Inicia sesión validando las credenciales del usuario.
     *
     * @param correo     Correo electrónico del usuario.
     * @param contraseña Contraseña en texto plano.
     * @return Token JWT si las credenciales son válidas.
     * @throws IllegalArgumentException Si las credenciales son inválidas.
     */
    public String iniciarSesion(String correo, String contrasena) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Validar si el usuario existe
            Usuario user = usuarioOpt.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

            // Verificar si las credenciales son correctas
            if (passwordService.matches(contrasena, usuario.getContrasena())) {

                // Consultar acceso_status directamente usando el correo
                Optional<Byte> accesoStatusOpt = accesoRepository.findAccesoStatusByUsuario_Correo(correo);

                if (accesoStatusOpt.isPresent()) {
                    Byte accesoStatus = accesoStatusOpt.get();

                    // Determinar el rol según accesoStatus
                    String rol = determinarRol(accesoStatus);

                    // Generar el token con el rol incluido
                    return jwtUtil.generarToken(correo, rol);
                } else {
                    throw new IllegalArgumentException("Usuario no tiene acceso registrado o su acceso está inactivo.");
                }
            }
        }

        throw new IllegalArgumentException("Correo o contraseña incorrectos");
    }

    
    
    
    
    /**
     * Determina el rol del usuario basándose en su acceso.
     *
     * @param accesoStatus El estado de acceso del usuario.
     * @return El rol del usuario: "ADMINISTRADOR" o "PROFESOR".
     */
    private String determinarRol(byte accesoStatus) {
        // Si el acceso está activo (accesoStatus == 1), asignamos rol de ADMINISTRADOR
        if (accesoStatus == 1) {
            return "ADMINISTRADOR";
        }

        // Si el acceso no está activo (accesoStatus == 0), asignamos rol de PROFESOR
        return "PROFESOR";
    }

    /**
     * Obtiene el rol del usuario basado en su correo consultando el repositorio de acceso.
     *
     * @param correo Correo del usuario.
     * @return Rol del usuario: "ADMINISTRADOR" o "PROFESOR".
     * @throws IllegalArgumentException Si el usuario no tiene acceso registrado.
     */
    public String obtenerRolDesdeAcceso(String correo) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Optional<Byte> accesoStatusOpt = accesoRepository.findAccesoStatusByUsuario_Correo(correo);

            if (accesoStatusOpt.isPresent()) {
                Byte accesoStatus = accesoStatusOpt.get();
                return determinarRol(accesoStatus); // Determinar el rol usando accesoStatus
            }
        }

        throw new IllegalArgumentException("Usuario no tiene acceso registrado.");
    }

    /**
     * Método para registrar un usuario con contraseña en texto plano (solo para pruebas).
     *
     * @param correo     Correo electrónico del usuario.
     * @param contraseña Contraseña en texto plano.
     */
    public void registrarUsuario(String correo, String contrasena) {
        // Guardar la contraseña tal cual (sin cifrar)
        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena); // Contraseña sin cifrado

        // Guardar el usuario con la contraseña en texto plano
        usuarioRepository.save(usuario);
    }
}
