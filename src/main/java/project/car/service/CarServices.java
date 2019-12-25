package project.car.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

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

	public List<CarroDTO> getAllCars() throws IOException {

		return carRepository.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
	}

	public Optional<CarroDTO> getCarById(Long id) throws IOException {

		return carRepository.findById(id).map(CarroDTO::create);
	}

	public void deleteCarById(Long id) throws IOException {
		carRepository.deleteById(id);
	}

	public Optional<CarroDTO> saveCar(Carro car) throws IOException {
		if(Objects.nonNull(car.getId())) throw new IOException("Id deve ser nulo");
		return Optional.ofNullable(carRepository.save(car)).map(CarroDTO::create);
	}

	public Optional<CarroDTO> updateCarById(Carro car)throws IOException {
		if(Objects.isNull(car.getId())) throw new IOException("Id não pode ser nulo");
		return Optional.ofNullable(carRepository.save(car)).map(CarroDTO::create);
	}

	public List<CarroDTO> getCarByTipo(String tipo) {
		return carRepository.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
	}
}
