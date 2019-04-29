package Data;

import java.util.ArrayList;

import javax.ejb.Local;

import Bussines.Noticia;
import Bussines.Publicacion;
import Bussines.dtNoticia;
import Bussines.dtNotpub;
import Bussines.dtPublicacion;

@Local
public interface DataJPALocal {
	public ArrayList<Noticia> cargarNoticias();	
	public ArrayList<Publicacion> cargarPublicaciones();
	public void guardarPub(Publicacion p);
	public void guardarNot(Noticia n);
}
