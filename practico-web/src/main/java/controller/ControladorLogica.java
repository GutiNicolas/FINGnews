package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Bussines.Noticia;
import Bussines.Publicacion;
import Bussines.ControladorLocal;

@Named
@SessionScoped
public class ControladorLogica implements Serializable {

	@EJB
	private ControladorLocal cl;
	private Noticia n = new Noticia();
	private int idn;
	private Publicacion p = new Publicacion();
	
	
	
	public Publicacion getP() {
		return p;
	}

	public void setP(Publicacion p) {
		this.p = p;
	}

	public int getIdn() {
		return idn;
	}

	public void setIdn(int idn) {
		this.idn = idn;
	}

	public Noticia getN() {
		return n;
	}

	public void setN(Noticia n) {
		this.n = n;
	}

	public ControladorLogica() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Noticia> noticias(){
		return cl.getNoticias();
	}
	
	public List<Publicacion> publicaciones(int id){
		return cl.getPubsfromNew(id);
	}

	public String addN() {
		cl.AgregarNoticia(this.n.getTitulo(), this.n.getDescripcion());
		this.n = new Noticia();
		return "noticias";
	}
	
	public String seleccionar(int id) {
		this.idn=id;
		return "addpub";
	}
	
	public String volver() {
		return "noticias";
	}
	
	public String listar(int id) {
		this.idn=id;
		return "listar";
	}
	
	
	public String addP() {
		cl.AddPublication2New(this.p.getTipo(), this.p.getUrl(), this.idn);
		this.p = new Publicacion();
		this.idn = 0;
		return "noticias";
	}
}
