package Data;

import javax.ejb.Local;

import Bussines.dtNoticia;
import Bussines.dtNotpub;
import Bussines.dtPublicacion;

import java.util.ArrayList;

@Local
public interface DataBeanLocal {
	
	public String hayDatos();
	public void conectar();
	public void desconectar();
	public void cargarNoticias(ArrayList<dtNoticia> noti);	
	public void cargarPublicaciones(ArrayList<dtPublicacion> prop);
	public void cargarNotpub(ArrayList<dtNotpub> np);
	public void guardarPub(dtPublicacion dtp,int idn);
	public void guardarNot(dtNoticia dtn);
}
