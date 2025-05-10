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

import co.edu.ue.entity.TipoNovedad;
import co.edu.ue.service.ITipoNovedadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "TipoNovedad", description = "Endpoints para gestionar el inventario de los equipos")
@RequestMapping("/tipo-novedad")
@Validated

public class TipoNovedadController {
	
	@Autowired
	ITipoNovedadService service;

	@Operation(summary = "Obtener los registros", description = "Retorna una lista de todos los registros disponibles en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
	
	//Obteber registros
	@GetMapping(value = "listanovedades")
	public ResponseEntity<List<TipoNovedad>> getAllTiposNovedad() {
		List<TipoNovedad> list = service.ListarTipoNovedad();
		return new ResponseEntity<List<TipoNovedad>>(list, HttpStatus.ACCEPTED);
	}
	
	//Obtener Tipo novedad por id
	@GetMapping(value="/tipo-novedad-id")
    public ResponseEntity<TipoNovedad> getByIdTipoNovedad(@RequestParam("id") int id) {
        return new ResponseEntity<TipoNovedad>(service.searchByTipoNovedad(id), HttpStatus.OK);
    }
	
	//Agregar equipo
	@PostMapping(value="/agregar-novedad")
	public ResponseEntity<Map<String, Object>> postTipoNovedad(@RequestBody TipoNovedad tipoNovedad) {
	    Map<String, Object> response = new HashMap<>();

	    if (service.postTipoNovedad(tipoNovedad)) {
	        response.put("mensaje", "Registro creado exitosamente");
	        response.put("tipoNovedad", tipoNovedad);
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }
	    response.put("mensaje", "Conflicto al registrar");
	    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	 
	 //Editar equipo
	 @Operation(summary="actualiza la informacion del cursos")
		@PutMapping(value="tipo-novedad-id")
		public ResponseEntity<TipoNovedad> updateTipoNovedad
		(@RequestBody TipoNovedad tipoNovedad, @RequestParam int id) {
			return new ResponseEntity<TipoNovedad> 
			(service.updateTipoNovedad(tipoNovedad, id),HttpStatus.CREATED);
		}
	
	 @DeleteMapping(value = "novedad-id")
	 public ResponseEntity<TipoNovedad> deleteByIdCourse(@RequestBody TipoNovedad tipoNovedad, @RequestParam int id) {
	     service.deleteTipoNovedad(id);
	     return ResponseEntity.ok().build(); // Devuelve un 200 OK sin cuerpo
	 }
		

}

