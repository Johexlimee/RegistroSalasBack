package co.edu.ue.controller;

import co.edu.ue.dao.LoginRequest;
import co.edu.ue.entity.Usuario;
import co.edu.ue.service.IUsuarioInterface;
import co.edu.ue.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

   

    @Autowired
    IUsuarioInterface service;
    
	
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerUser(@RequestBody Usuario usuario) {
		try {
			Usuario registeredUser = service.registerUser(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error al registrar el usuario: " + e.getMessage());
		}
	}
    
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginRequest loginRequest) {
        try {
            String correo = loginRequest.getCorreo();
            String contrasena = loginRequest.getContrasena();

            if (correo == null || contrasena == null) {
                return ResponseEntity.badRequest().body("Faltan credenciales (correo o contraseña)");
            }

            // Generar el token y determinar el rol basado en acceso_status
            String token = service.iniciarSesion(correo, contrasena);
            if (token == null) {
                return ResponseEntity.status(401).body("Credenciales inválidas");
            }

            String rol = service.obtenerRolDesdeAcceso(correo); // Determinar el rol

            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("token", token);
            respuesta.put("rol", rol);

            return ResponseEntity.ok(respuesta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body("Credenciales inválidas: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor: " + e.getMessage());
        }
    }
}
