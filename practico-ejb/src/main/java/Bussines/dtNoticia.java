package Bussines;

import java.io.Serializable;

public class dtNoticia implements Serializable{

	public int id;
	public String titulo;
	public String descripcion;


	public dtNoticia(int id, String titulo, String descripcion) {
		this.id=id;
		this.titulo=titulo;
		this.descripcion=descripcion;
	}
	
}
