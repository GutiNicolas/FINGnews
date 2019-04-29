package Bussines;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class RestfulServices
 * MediaType.APPLICATION_XML
 */
@Stateless
@LocalBean
@Path("/controlador")
public class RestfulServices implements RestfulServicesLocal {

    /**
     * Default constructor. 
     */
    public RestfulServices() {
        // TODO Auto-generated constructor stub
    }
    
    
	@EJB private ControladorLocal con;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Noticias")
	public JsonArray findAll() {
		JsonArrayBuilder list = Json.createArrayBuilder();
		for (int key : con.findAll().keySet()) {
			list.add(con.findAll().get(key).toJson());
		}
		return list.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Publicaciones/{idn}")
	public JsonArray findAllPubs(@PathParam("idn") int idn) {
		JsonArrayBuilder list = Json.createArrayBuilder();
		for (Publicacion p : con.getPubsfromNew(idn)) {
			dtCrearPublicacion dtcp = new dtCrearPublicacion(p.getTipo(), p.getUrl(), Integer.toString(idn));
			list.add(dtcp.toJson());
		}
		return list.build();
	}
	
	@GET
	@Path("/Hola")
	public String getHola() {
		return "Hola";
	}
	
	@POST
	@Path("/CrearNoticia")
	public Response save(@Valid Noticia noti) {
		con.AgregarNoticia(noti.getTitulo(), noti.getDescripcion());
		return Response.ok().build();
	}
	
	@POST
	@Path("/CrearPublicacion")
	public Response savedos(@Valid dtCrearPublicacion pub) {
		con.AddPublication2New(pub.tipo, pub.url, Integer.parseInt(pub.idn));
		return Response.ok().build();
	}
	
	/**
	 * Para crear una noticia:
	 * curl -i -H "Content-Type: application/json" -X POST -d '{"titulo":"Noticia desde REST", "descripcion":"una descripcion"}' http://localhost:8080/practico-web/rest/controlador/CrearNoticia
	 * curl -i -H "Content-Type: application/json" -X POST -d '{"tipo":"Tweet", "url":"http://twitter.com", "idn":"4"}' http://localhost:8080/practico-web/rest/controlador/CrearPublicacion
	 */
	

}
