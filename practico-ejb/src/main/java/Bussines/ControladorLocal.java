package Bussines;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.json.JsonArray;

@Local
public interface ControladorLocal {
	
	public String AddPublication2New(String pubtipe,String puburl, int newid);
	public List<Noticia> ListNews();
	public List<Publicacion> Pubs4New(int id);
	public String hayDatos();
	public boolean cargarDatos();
	public List<dtNoticia> ListarNoticias();
	public List<dtPublicacion> ListarPublicaciones(int idn);
	public dtNoticia obtenerNoticia(int idn);
	public void AgregarNoticia(String titulo, String descripcion);
	public Map<Integer,Noticia> findAll();
	public boolean cargarDatosJPA();
	public List<Publicacion> getPubsfromNew(int idn);
	public List<Noticia> getNoticias();
}
