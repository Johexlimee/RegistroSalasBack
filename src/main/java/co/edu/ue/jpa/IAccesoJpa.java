package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Acceso;
import java.util.Optional;

@Repository
public interface IAccesoJpa extends JpaRepository<Acceso, Integer> {

    // Método para encontrar un acceso por el usuario_id
    Optional<Acceso> findByUsuario_IdUsuario(Long idUsuario);

    // Cambiar este método para que haga una consulta personalizada
    @Query("SELECT a.accesoStatus FROM Acceso a WHERE a.usuario.correo = :correo")
    Optional<Byte> findAccesoStatusByUsuario_Correo(@Param("correo") String correo);
}

