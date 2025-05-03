package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Novedad;
import co.edu.ue.service.INovedadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Novedad", description = "Endpoints para gestionar el inventario de los Novedads")
@RequestMapping("Novedad")
@Validated
public class NovedadController {
	@Autowired
	INovedadService service;

	@Operation(summary = "Obtener los registros", description = "Retorna una lista de todos los registros disponibles en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
	
	//Obtener registros
	@GetMapping(value = "listaNovedades")
	public ResponseEntity<List<Novedad>> getAllControl() {
		List<Novedad> list = service.ListarNovedad();
		return new ResponseEntity<List<Novedad>>(list, HttpStatus.ACCEPTED);
	}
	
	//Obtener Novedad por id
	@GetMapping(value="Novedad-id")
    public ResponseEntity<Novedad> getByIdNovedads(@RequestParam("id") int id) {
        return new ResponseEntity<Novedad>(service.searchByIdNovedad(id), HttpStatus.OK);
    }
	
	//Agregar Novedad
	 @PostMapping(value="Agregar-Novedad")
	    public ResponseEntity<Void> postNovedads(@RequestBody Novedad novedad) {
	        if (service.postNovedad(novedad)) {
	            return new ResponseEntity<Void>(HttpStatus.CREATED);
	        }
	        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 
	 //Editar Novedad
	 @Operation(summary="actualiza la informacion del cursos")
		@PutMapping(value="course-id")
		public ResponseEntity<Novedad>  updateNovedads(@RequestBody Novedad novedad, @RequestParam int id) {
			return new ResponseEntity<Novedad> (service.updateNovedad(novedad, id),HttpStatus.CREATED);
		}
	 
	


}
