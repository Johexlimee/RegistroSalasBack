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
import co.edu.ue.entity.Equipo;
import co.edu.ue.entity.Sala;
import co.edu.ue.service.ISalaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
 
 
@RestController

@Tag(name = "Sala", description = "Endpoints para gestionar el llamado de cada sala")

@RequestMapping("sala")

@CrossOrigin("*") //Direcion Ip donde se recibiran las peticiones

@Validated

public class SalaController {

	@Autowired

	ISalaService service;

 
	//toda la tabla

	@Operation(summary = "Obtener las salas", description = "Retorna una lista de todas las salas disponibles en la base de datos.")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),

            @ApiResponse(responseCode = "500", description = "Error interno del servidor")

    })

	@GetMapping(value = "/all")

	public ResponseEntity<List<Sala>> getAllSala() {

		List<Sala> list = service.listarSala();

		int cantList = list.size();

		HttpHeaders headers = new HttpHeaders();

		headers.add("cant_elements", String.valueOf(cantList));

		headers.add("test", "hola");

		return new ResponseEntity<List<Sala>>(list, headers, HttpStatus.ACCEPTED);

	}

 
	//por id

	 @Operation(summary = "Buscar sala por ID", description = "Busca una sala específica utilizando su identificador único.")

	    @ApiResponses(value = {

	            @ApiResponse(responseCode = "200", description = "sala encontrada"),

	            @ApiResponse(responseCode = "404", description = "sala no encontrada")

	    })

	@GetMapping(value="Sala-id")

	public ResponseEntity<Sala> getByIdSala(@RequestParam int id_sala) {

		return new ResponseEntity<Sala>(service.buscarById(id_sala),HttpStatus.OK);

	}
 
	//Obteber registros

	 @GetMapping (value="ListarSalas")

	    public ResponseEntity<List<Sala>>listarSalas() {

	        List<Sala> salas = service.ListarSala();

	        return ResponseEntity.ok(salas);

	    }

 
}

 