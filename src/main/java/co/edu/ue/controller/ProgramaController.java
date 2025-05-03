package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.ue.entity.Programa;
import co.edu.ue.service.IProgramaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Programa", description = "Endpoints para gestionar el llamado de cada programa")
@RequestMapping("programa")
@CrossOrigin("*") //Direcion Ip donde se recibiran las peticiones
@Validated
public class ProgramaController {
	
	@Autowired
	IProgramaService service;
	
	//toda la tabla
	@Operation(summary = "Obtener los programas", description = "Retorna una lista de todos los programas disponibles en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
	@GetMapping(value = "/all")
	public ResponseEntity<List<Programa>> getAllPrograma() {
		List<Programa> list = service.listarPrograma();
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		return new ResponseEntity<List<Programa>>(list, headers, HttpStatus.ACCEPTED);
	}
	
	
	
	//por id
	
	 @Operation(summary = "Buscar programa por ID", description = "Busca un programa específico utilizando su identificador único.")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "programa encontrado"),
	            @ApiResponse(responseCode = "404", description = "programa no encontrado")
	    })
	
	@GetMapping(value="Programa-id")
	public ResponseEntity<Programa> getByIdSala(@RequestParam int id_programa) {
		return new ResponseEntity<Programa>(service.buscarByIdP(id_programa),HttpStatus.OK);
	}

}
