package Bussines;

import java.io.Serializable;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;


/**
 * The persistent class for the publicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Publicacion.findAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idp;

	private String tipo;

	private String url;

	//bi-directional many-to-one association to Noticia
	@ManyToOne
	@JoinColumn(name="idn")
	private Noticia noticia;

	public Publicacion() {
	}
	
	public Publicacion(int idp, String url, String tipo) {
		this.idp=idp;
		this.tipo=tipo;
		this.url=url;
	}

	public Integer getIdp() {
		return this.idp;
	}

	public void setIdp(Integer idp) {
		this.idp = idp;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Noticia getNoticia() {
		return this.noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	

}