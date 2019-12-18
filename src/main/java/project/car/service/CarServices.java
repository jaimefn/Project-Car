package project.car.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import project.car.dto.CarroDTO;
import project.car.entity.Carro;
import project.car.repository.CarRepository;

@Service
public class CarServices {

	@Autowired
	private CarRepository carRepository; 
	
	
	public CarServices() {
		
	}
	
	public List<CarroDTO> getAllCars() {
				
		return carRepository.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());
	}
	
	public Optional<CarroDTO> getCarById(Long id) {
		
		return carRepository.findById(id).map(CarroDTO::new);
	}
	
	public void deleteCarById(Long id) {
		carRepository.deleteById(id);
	}
	
	public Optional<CarroDTO> saveCar(Carro car) {
		return Optional.ofNullable(carRepository.save(car)).map(CarroDTO::new);
	}

	public Optional<CarroDTO> updateCarById(Carro car) {
		return Optional.ofNullable(carRepository.save(car)).map(CarroDTO::new);
	}

	public List<CarroDTO> getCarByTipo(String tipo) {
		return carRepository.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());
	}
}
