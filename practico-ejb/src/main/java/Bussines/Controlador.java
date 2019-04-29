package Bussines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Data.DataBeanLocal;
import Data.DataJPALocal;

/**
 * Session Bean implementation class Controlador
 */
@Stateless
@WebService
public class Controlador implements ControladorRemote, ControladorLocal {

	
	@EJB private DataBeanLocal db;
	@EJB private DataJPALocal dbjpa;
	
	private Map<Integer,Noticia> noticias = new HashMap<>();
	private int idN;
	private int idP;
	
    /**
     * Default constructor. 
     */
    public Controlador() {
        // TODO Auto-generated constructor stub
    		
    }

	@Override
	@WebMethod(operationName="AddPublication2New")
	public String AddPublication2New(@WebParam(name="pubtipe") String pubtipe,@WebParam(name="puburl") String puburl,@WebParam(name="newid") int newid) {
		Noticia n= this.noticias.get(newid);
		if(n!=null) {
			if(!pubtipe.isEmpty()) {
				if(!puburl.isEmpty()) {
					Publicacion p= new Publicacion(idP,puburl,pubtipe);
					idP++;
					p=n.addPublicacion(p);
					dbjpa.guardarPub(p);
		//			dtPublicacion dtp= new dtPublicacion(p.getIdp(),p.getUrl(),p.getTipo());
		//			db.conectar();
		//			db.guardarPub(dtp, newid);
		//			db.desconectar();
					return "PUBLICACION AGREGADA CON EXITO!";
				}
				else
					return "LA URL NO PUEDE SER VACIA";
			}
			else
				return "EL TIPO NO PUEDE SER VACIO";
		}
		else
			return "LA NOTICIA CON ID "+newid+" NO EXISTE";
	}

	@Override
	public List<Noticia> ListNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> Pubs4New(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	public String hayDatos() {
		return "Hola desde COntrolador";
	}

	@Override
	public boolean cargarDatos() {
		db.conectar();
		ArrayList<dtNoticia> news = new ArrayList<>();
		ArrayList<dtPublicacion> pubs = new ArrayList<>();
		ArrayList<dtNotpub> links = new ArrayList<>();
		db.cargarNoticias(news);
		db.cargarPublicaciones(pubs);
		db.cargarNotpub(links);
		db.desconectar();
		for (int i=0; i<news.size();i++) {
			dtNoticia dtn= news.get(i);
			Noticia n=new Noticia(dtn.id,dtn.titulo,dtn.descripcion);
			noticias.put(n.getId(), n);
		}
		idN=news.size();
		idN++;
		
		Map<Integer,Publicacion> pubstemp = new HashMap<>();
		for (int i=0; i<pubs.size();i++) {
			dtPublicacion dtp= pubs.get(i);
			Publicacion p=new Publicacion(dtp.id,dtp.url,dtp.tipo);
			pubstemp.put(p.getIdp(), p);
		}
		
		for (int i=0; i<links.size(); i++) {
			dtNotpub dtnp= links.get(i);
			Noticia n=this.noticias.get(dtnp.idn);
			n.addPublicacion(pubstemp.get(dtnp.idp));
		}
		idP=pubstemp.size();
		idP++;
		pubstemp.clear();
		
		return true;
	}

	@Override
	@WebMethod(operationName="ListarNoticias")
	public List<dtNoticia> ListarNoticias() {
		ArrayList<dtNoticia> adtn= new ArrayList<>();
		for ( int key : this.noticias.keySet()) {
			Noticia n= this.noticias.get(key);
			dtNoticia dtn = new dtNoticia(n.getId(),n.getTitulo(),n.getDescripcion());
			adtn.add(dtn);
		}
		
		return adtn;
	}

	@Override
	@WebMethod(operationName="ListarPublicaciones")
	public List<dtPublicacion> ListarPublicaciones(@WebParam(name = "idn") int idn) {
		ArrayList<dtPublicacion> adtp= new ArrayList<>();
		Noticia n= this.noticias.get(idn);
		if(n!=null) {
			if (!n.getPublicacions().isEmpty()) {
			for (Publicacion p : n.getPublicacions()) {
				dtPublicacion dtp = new dtPublicacion(p.getIdp(),p.getUrl(),p.getTipo());
				adtp.add(dtp);	
				
			}
			}else {
				dtPublicacion dtp = new dtPublicacion(0,"Sin publicaciones","ADVERTENCIA");
				adtp.add(dtp);
			}
					
		}

		return adtp;
	}

	@Override
	public dtNoticia obtenerNoticia(int idn) {
		Noticia n = this.noticias.get(idn);
		dtNoticia r= new dtNoticia(idn, n.getTitulo(), n.getDescripcion() );
		return r;
	}

	@Override
	public void AgregarNoticia(String titulo, String descripcion) {
		// TODO Auto-generated method stub
		Noticia n = new Noticia(idN, titulo, descripcion);
		idN++;
	//	dtNoticia dtn= new dtNoticia(n.getId(), n.getTitulo(), n.getDescripcion());
	//	db.guardarNot(dtn);
		dbjpa.guardarNot(n);
		this.noticias.put(n.getId(), n);
	}

	@Override
	public boolean cargarDatosJPA() {
		// TODO Auto-generated method stub
		ArrayList<Noticia> ln= dbjpa.cargarNoticias();
		ArrayList<Publicacion> lp= dbjpa.cargarPublicaciones();

		idN=ln.size();
		idN++;
		idP=lp.size();
		idP++;
		for ( Noticia n : ln) {
			this.noticias.put(n.getId(), n);
			System.out.println(n.getTitulo());
			System.out.println("Size publicaciones: "+n.getPublicacions().size());
		}
		
	//	for ( Publicacion p : lp) {
	//		Noticia n = this.noticias.get(p.getNoticia().getId());
	//		n.addPublicacion(p);
	//		System.out.println("Publicacion "+p.getIdp()+" Agregada a Noticia "+n.getId());
	//	} 
		
		return true;
	}
	
	public List<Noticia> Map2List() {
		List<Noticia> ret = new ArrayList<>();
		for (int key : this.noticias.keySet()) {
			ret.add(this.noticias.get(key));
		}
		return ret;
	}
	
	
	public Map<Integer,Noticia> findAll() {
		return this.noticias;
	}

	@Override
	public List<Publicacion> getPubsfromNew(int idn) {
		// TODO Auto-generated method stub
		Noticia n= this.noticias.get(idn);
		return n.getPublicacions();
	}

	@Override
	public List<Noticia> getNoticias() {
		List<Noticia> list= new ArrayList<>();
		for (int key : this.noticias.keySet()) {
			list.add(this.noticias.get(key));
		}
		return list;
	}

}
