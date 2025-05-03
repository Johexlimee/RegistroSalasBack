package co.edu.ue.jpa;

import co.edu.ue.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IUsuarioJpa extends JpaRepository<Usuario, Long> {
    
    // Método para buscar un usuario por correo
    Optional<Usuario> findByCorreo(String correo);
}
