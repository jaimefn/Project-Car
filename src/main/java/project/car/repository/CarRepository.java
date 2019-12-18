package project.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import project.car.entity.Carro;


public interface CarRepository extends JpaRepository<Carro, Long> {

	List<Carro> findByTipo(String tipo);

}
