package project.car.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.mapstruct.MapMapping;
import org.modelmapper.ModelMapper;

import io.swagger.annotations.Api;
import lombok.Data;
import project.car.entity.Carro;

@Data
@Api(value = "CarroDTO_Value")
public class CarroDTO {
	private Long id;
	private String nome;
	private String descricao;
	private String tipo;
	
	public static CarroDTO create(Carro c) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(c, CarroDTO.class);
	}


}
