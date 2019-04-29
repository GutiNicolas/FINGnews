package Bussines;

import java.io.Serializable;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descripcion;

	private String titulo;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="noticia", fetch = FetchType.EAGER)
	private List<Publicacion> publicacions;

	public Noticia() {
	}
	
	public Noticia(int id, String titulo, String descripcion) {
		this.id=id;
		this.titulo=titulo;
		this.descripcion=descripcion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		this.publicacions.add(publicacion);
		publicacion.setNoticia(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setNoticia(null);

		return publicacion;
	}

	public Map<Integer, Publicacion> getPublicacionsHash() {
		Map<Integer, Publicacion> map = new HashMap<>();
		for (Publicacion p : getPublicacions()) {
			map.put(p.getIdp(), p);
		}
		return map;
	}
	
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("titulo", this.titulo)
				.add("descripcion", this.descripcion)
				.build();
		
	}

}