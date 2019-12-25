package project.car.rest;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.websocket.server.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.car.dto.CarroDTO;
import project.car.entity.Carro;
import project.car.service.CarServices;

@Api(value = "Rest API With Swagger")
@RestController
@RequestMapping("/api/v1/carros")
public class CarController {

	@Autowired
	private CarServices carServices;

	@ApiOperation(value = "Busca um carro na lista")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity GetCarById(@PathVariable Long id) throws IOException{

		Optional<CarroDTO> carro = carServices.getCarById(id);

		 return carro.isPresent()?
		 ResponseEntity.status(HttpStatus.OK).body(carro.get()):
		 ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}


	@ApiOperation(value = "Busca um carro pelo tipo")
	@RequestMapping(method = RequestMethod.GET, value = "/tipo/{tipo}")
	public ResponseEntity GetCarByTipo(@PathVariable String tipo) throws IOException {
		List<CarroDTO> listCarroDTO = carServices.getCarByTipo(tipo);

		return listCarroDTO.isEmpty() ? ResponseEntity.noContent().build()
				: ResponseEntity.status(HttpStatus.OK).body(listCarroDTO);
	}

	@ApiOperation(value = "Busca todos os carros da lista")
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ResponseEntity GetAllCars()  throws IOException{
		List<CarroDTO> listCarroDTO = carServices.getAllCars();
		return listCarroDTO.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.status(HttpStatus.OK).body(listCarroDTO);
	}

	@ApiOperation(value = "Salva um carro na lista")
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity SaveCar(@RequestBody Carro car) throws IOException{
		Optional<CarroDTO> carroDTO;
		try {
			carroDTO = carServices.saveCar(car);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return carroDTO.isEmpty()?
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build():
					ResponseEntity.created(getUri(carroDTO.get().getId())).body(carroDTO.get());
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
	}

	@ApiOperation(value = "Deleta um carro da lista")
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	public ResponseEntity DeleteCarById(@RequestParam Long id) throws IOException{
		carServices.deleteCarById(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Atualiza um carro na lista")
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public ResponseEntity UpdateCarById(@RequestBody Carro car) throws IOException {
		return carServices.updateCarById(car).isEmpty()?ResponseEntity.notFound().build():
			ResponseEntity.ok().build();
	}
	
}
