package Bussines;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ControladorRemote {
	
	public String AddPublication2New(String pubtipe,String puburl, int newid);
	public List<Noticia> ListNews();
	public List<Publicacion> Pubs4New(int id);
	public String hayDatos();
	public boolean cargarDatos();
	public List<dtNoticia> ListarNoticias();
	public List<dtPublicacion> ListarPublicaciones(int idn);
	public void AgregarNoticia(String titulo, String descripcion);
	public boolean cargarDatosJPA();
}
