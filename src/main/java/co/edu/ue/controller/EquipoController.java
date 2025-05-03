package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Equipo;
import co.edu.ue.service.IEquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Equipo", description = "Endpoints para gestionar el inventario de los equipos")
@RequestMapping("equipos")
@CrossOrigin("*") // Dirección IP donde se recibirán las peticiones
@Validated
public class EquipoController {

    @Autowired
    IEquipoService service;

    @Operation(summary = "Obtener lista de todos los equipos",
               description = "Retorna una lista de todos los equipos disponibles en el sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("listaEquipos")
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> list = service.ListarEquipos();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Actualizar un equipo",
               description = "Permite actualizar la información de un equipo existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Equipo actualizado correctamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud con datos inválidos"),
        @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @PutMapping("editarEquipo-id")
    public ResponseEntity<Equipo> updateEquipos(@RequestBody Equipo equipo, @RequestParam int id) {
        Equipo equipoActualizado = service.updateEquipo(equipo, id);
        return new ResponseEntity<>(equipoActualizado, HttpStatus.OK);
    }

    @Operation(summary = "Agregar un nuevo equipo",
               description = "Permite agregar un nuevo equipo al sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Equipo agregado correctamente"),
        @ApiResponse(responseCode = "400", description = "Faltan datos obligatorios"),
        @ApiResponse(responseCode = "409", description = "Conflicto al agregar el equipo")
    })
    @PostMapping("agregar-equipo")
    public ResponseEntity<String> postEquipos(@RequestBody Equipo equipo) {
        boolean resultado = service.postEquipo(equipo);
        if (resultado) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("cambiarEstado/{id}")
    @Operation(summary = "Cambia el estado de un equipo", description = "Este endpoint cambia el estado de un equipo de activo (true) a inactivo (false) o viceversa.")
    public ResponseEntity<Equipo> cambiarEstadoEquipo(@PathVariable int id) {
        try {
            // Llama al servicio para cambiar el estado
            Equipo equipoActualizado = service.cambiarEstadoEquipo(id, null);

            // Devuelve el equipo actualizado con código 200 OK
            return new ResponseEntity<>(equipoActualizado, HttpStatus.OK);
        } catch (RuntimeException ex) {
            // Si no se encuentra el equipo, devuelve 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Filtrar equipos por tipo",
               description = "Permite filtrar los equipos en función de su tipo.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de equipos filtrados correctamente"),
        @ApiResponse(responseCode = "400", description = "Tipo de equipo inválido")
    })
    @DeleteMapping(value = "eliminarEquipo/{id}")
    public ResponseEntity<Void> deleteByIdEquipo(@PathVariable int id) {
        try {
            // Llama al servicio para eliminar el equipo
            service.deleteEquipo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException ex) {
            // Si no se encuentra el equipo, devuelve 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = " Eliminar (el estado) un curso de la base de datos")
	@DeleteMapping(value="deleteByIdEquipo")
	public ResponseEntity<Equipo>  deleteByIdEquipo(@RequestBody Equipo  equipo , @RequestParam int id) {
		return new ResponseEntity<Equipo> (service.cambiarEstado(id, equipo),HttpStatus.OK);
	}
}

