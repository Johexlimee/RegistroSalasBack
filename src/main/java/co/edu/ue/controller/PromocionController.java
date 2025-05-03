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

import co.edu.ue.entity.Promocion;
import co.edu.ue.service.IPromocionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Promocion", description = "Endpoints para gestionar el llamado de cada promocion")
@RequestMapping("promocion")
@CrossOrigin("*") //Direcion Ip donde se recibiran las peticiones
@Validated
public class PromocionController {
	
	@Autowired
	IPromocionService service;
	
	
	//toda la tabla
	@Operation(summary = "Obtener las promociones", description = "Retorna una lista de todos las promociones disponibles en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
	@GetMapping(value = "/all")
	public ResponseEntity<List<Promocion>> getAllPromocion() {
		List<Promocion> list = service.listarPromocion();
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		return new ResponseEntity<List<Promocion>>(list, headers, HttpStatus.ACCEPTED);
	}
	
	
	//por id
	
	 @Operation(summary = "Buscar promoción por ID", description = "Busca una promoción específica utilizando su identificador único.")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "promoción encontrada"),
	            @ApiResponse(responseCode = "404", description = "promoción no encontrada")
	    })
	
	@GetMapping(value="Prom-id")
	public ResponseEntity<Promocion> getByIdSala(@RequestParam int id_prom) {
		return new ResponseEntity<Promocion>(service.buscarByIdPm(id_prom),HttpStatus.OK);
	}

}
