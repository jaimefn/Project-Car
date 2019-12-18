package project.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name =  "carro")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	@Column(name = "url_foto")
	private String urlFoto;
	@Column(name = "url_video")
	private String urlVideo;
	private String latitude;
	private String longitude;
	private String tipo;
	
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

	public String getUrl_foto() {
		return urlFoto;
	}

	public void setUrl_foto(String url_foto) {
		this.urlFoto = url_foto;
	}

	public String getUrlvideo() {
		return urlVideo;
	}

	public void setUrlvideo(String urlvideo) {
		this.urlVideo = urlvideo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "CarDTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", url_foto=" + urlFoto
				+ ", urlvideo=" + urlVideo + ", latitude=" + latitude + ", longitude=" + longitude + ", tipo=" + tipo
				+ "]";
	}

}
