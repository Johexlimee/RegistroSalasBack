package co.edu.ue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.TipoEquipo;
import co.edu.ue.service.ITipoEquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Tipo Equipo", description = "Endpoints para gestionar el inventario de los equipos")
@RequestMapping("Tipo-Equipo")
@Validated

public class TipoEquipoController {
	//comnetari de sofia de prueba
	@Autowired
	ITipoEquipoService service;

	@Operation(summary = "Obtener los registros", description = "Retorna una lista de todos los registros disponibles en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
	
	//Obteber registros
	@GetMapping(value = "ListarTiposEquipos")
	public ResponseEntity<List<TipoEquipo>> getAllTiposEquipos() {
		List<TipoEquipo> list = service.ListarTipoEquipo();
		return new ResponseEntity<List<TipoEquipo>>(list, HttpStatus.ACCEPTED);
	}
	
	//Obtener Tipo TipoEquipo por id
	@GetMapping(value="TipoEquipo-id")
    public ResponseEntity<TipoEquipo> getByIdTipoEquipo(@RequestParam("id") int id) {
        return new ResponseEntity<TipoEquipo>(service.searchByIdTipoEquipo(id), HttpStatus.OK);
    }
	
	@PostMapping(value="AgregarTipoEquipo")
	public ResponseEntity<Map<String, String>> postTipoEquipo(@RequestBody TipoEquipo tipoEquipo) {
	    Map<String, String> response = new HashMap<>();

	    if (service.existsByNombre(tipoEquipo.getNombre())) {
	        response.put("error", "Este tipo de equipo ya está registrado.");
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	    }

	    boolean resultado = service.postTipoEquipo(tipoEquipo);
	    
	    if (resultado) {
	        response.put("message", "Tipo de equipo agregado correctamente.");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }

	    response.put("error", "Error interno al agregar el tipo de equipo.");
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	 
	 //Editar equipo
	 @Operation(summary="actualiza la informacion del cursos")
		@PutMapping(value="TipoEquipo-id")
		public ResponseEntity<TipoEquipo> updateTipoEquipo
		(@RequestBody TipoEquipo TipoEquipo, @RequestParam int id) {
			return new ResponseEntity<TipoEquipo> 
			(service.updateTipoEquipo(TipoEquipo, id),HttpStatus.CREATED);
		}
	 

 
	
	 /*@DeleteMapping(value = "TipoEquipo-id")
	 public ResponseEntity<TipoEquipo> deleteByIdCourse(@RequestBody TipoEquipo tipoEquipo, @RequestParam int id) {
	     service.deleteTipoEquipo(id);
	     return ResponseEntity.ok().build(); // Devuelve un 200 OK sin cuerpo
	 }
*/
}
