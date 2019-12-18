package project.car.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.Api;
import project.car.entity.Carro;

@Api(value = "CarroDTO_Value")
public class CarroDTO {
	private Long id;
	private String nome;
	private String descricao;
	private String tipo;
	
	public CarroDTO() {}
	
	
	public CarroDTO(Carro c) {
		this.id = c.getId();
		this.nome = c.getNome();
		this.descricao = c.getDescricao();
		this.tipo = c.getTipo();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
