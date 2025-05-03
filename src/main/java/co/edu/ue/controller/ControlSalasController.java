package co.edu.ue.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import co.edu.ue.entity.Controlsala;
import co.edu.ue.service.IControlSalasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
 
@RestController
@Tag(name = "Control Sala", description = "Endpoints para gestionar los registros en las salas")
@RequestMapping("control-salas")
@CrossOrigin("*") //Direcion Ip donde se recibiran las peticiones
@Validated
public class ControlSalasController {
 
	@Autowired
	IControlSalasService service;

	//toda la tabla
	
	@Operation(summary = "Obtener los registros", description = "Retorna una lista de todos los registros disponibles en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
	@GetMapping(value = "/all")
	public ResponseEntity<List<Controlsala>> getAllControl() {
		List<Controlsala> list = service.listarControl();
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		return new ResponseEntity<List<Controlsala>>(list, headers, HttpStatus.ACCEPTED);
	}
	
	//por id
	
	 @Operation(summary = "Buscar registro por ID", description = "Busca un registro específico utilizando su identificador único.")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "registro encontrado"),
	            @ApiResponse(responseCode = "404", description = "registro no encontrado")
	    })
	 
	@GetMapping(value="control-id")
	public ResponseEntity<Controlsala> getByIdControl(@RequestParam int id) {
		return new ResponseEntity<Controlsala>(service.searchById(id),HttpStatus.OK);
	}
	 //crear
	 @Operation(
	    	    summary = "Agregar un nuevo registro",
	    	    description = "Este endpoint permite crear un nuevo detalle en la base de datos.",
	    	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	    	        description = "Objeto que representa los detalles de un nuevo producto, incluyendo información del nombre de voceros, su código, fecha, programa, sala, promoción",
	    	        content = @Content(
	    	            mediaType = "application/json",
	    	            schema = @Schema(
	    	            		 example = "{\n" +
	    	            	              "  \"codigoBocero1\": \"123\",\n" +
	    	            	              "  \"codigoBocero2\": \"456\",\n" +
	    	            	              "  \"fecha\": \"2024-11-26T21:11:05.849Z\",\n" +
	    	            	              "  \"horaEntrada\": \"08:00:00\",\n" +
	    	            	              "  \"horaSalida\": \"10:00:00\",\n" +
	    	            	              "  \"nombreBocero1\": \"Juan Pérez\",\n" +
	    	            	              "  \"nombreBocero2\": \"Ana Gómez\",\n" +
	    	            	              "  \"descripcion\": \"Este es un ejemplo de descripción.\",\n" +
	    	            	              "  \"descripcion_dos\": \"Otra descripción adicional.\",\n" +
	    	            	              "  \"programa\": {\n" +
	    	            	              "    \"idPrograma\": 2\n" +
	    	            	              "  },\n" +
	    	            	              "  \"promocion\": {\n" +
	    	            	              "    \"idProm\": 1\n" +
	    	            	              "  },\n" +
	    	            	              "  \"sala\": {\n" +
	    	            	              "    \"idSala\": 1\n" +
	    	            	              "  },\n" +
	    	            	              "  \"usuario\": {\n" +
	    	            	              "    \"idUsuario\": 1\n" +
	    	            	              "  }\n" +
	    	            	              "}"
	    	            )
	    	        )
	    	    )
	    	)
	 @PostMapping(value = "registro")
	 public ResponseEntity<?> postControl(@Valid @RequestBody Controlsala controlsala) {
		 System.out.println("Solicitud recibida para registrar sala: " + controlsala);
	     try {
	         Controlsala savedControlsala = service.postControlsala(controlsala);
	         if (savedControlsala != null) {
	        	 System.out.println("Sala registrada con éxito: " + savedControlsala);
	             return new ResponseEntity<>(savedControlsala, HttpStatus.CREATED);
	         } else {
	             return new ResponseEntity<>("Error al guardar el registro", HttpStatus.BAD_REQUEST);
	         }
	     } catch (Exception e) {
	         return new ResponseEntity<>("Error interno: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }


 
	//actualizar
	 @Operation(
	    	    summary = "Actualizar los datos del registro",
	    	    description = "Este endpoint permite crear un nuevo detalle de producto en la base de datos.",
	    	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	    	        description = "Objeto que representa los detalles de un nuevo producto, incluyendo información del nombre de voceros, su código, fecha, programa, sala, promoción",
	    	        content = @Content(
	    	            mediaType = "application/json",
	    	            schema = @Schema(
	    	            		 example = "{\n" +
	    	            	              "  \"codigoBocero1\": \"123\",\n" +
	    	            	              "  \"codigoBocero2\": \"456\",\n" +
	    	            	              "  \"fecha\": \"2024-11-26T21:11:05.849Z\",\n" +
	    	            	              "  \"horaEntrada\": \"08:00:00\",\n" +
	    	            	              "  \"horaSalida\": \"10:00:00\",\n" +
	    	            	              "  \"nombreBocero1\": \"Juan Pérez\",\n" +
	    	            	              "  \"nombreBocero2\": \"Ana Gómez\",\n" +
	    	            	              "  \"descripcion\": \"Este es un ejemplo de descripción.\",\n" +
	    	            	              "  \"descripcion_dos\": \"Otra descripción adicional.\",\n" +
	    	            	              "  \"programa\": {\n" +
	    	            	              "    \"idPrograma\": 2\n" +
	    	            	              "  },\n" +
	    	            	              "  \"promocion\": {\n" +
	    	            	              "    \"idProm\": 1\n" +
	    	            	              "  },\n" +
	    	            	              "  \"sala\": {\n" +
	    	            	              "    \"idSala\": 1\n" +
	    	            	              "  },\n" +
	    	            	              "  \"usuario\": {\n" +
	    	            	              "    \"idUsuario\": 1\n" +
	    	            	              "  }\n" +
	    	            	              "}"
	    	            )
	    	        )
	    	    )
	    	)
	@PutMapping(value="control-id")
	public ResponseEntity<Controlsala>  updateControl(@Valid @RequestBody
 
			Controlsala controlsala, @RequestParam int id) {
		return new ResponseEntity<Controlsala> (service.updateControlsala(controlsala, id),HttpStatus.CREATED);
	}
	 
	 @Operation(summary = "Obtener el último registro", description = "Retorna el último registro de la tabla Controlsala.")
	 @ApiResponses(value = {
	     @ApiResponse(responseCode = "200", description = "Último registro encontrado"),
	     @ApiResponse(responseCode = "404", description = "No hay registros")
	 })
	 @GetMapping(value = "/ultimo-registro")
	 public ResponseEntity<Controlsala> getUltimoRegistro() {
	     Controlsala ultimoRegistro = service.obtenerUltimoRegistro();
	     if (ultimoRegistro != null) {
	         return new ResponseEntity<>(ultimoRegistro, HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }

}
