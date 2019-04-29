package Data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Bussines.Noticia;
import Bussines.Publicacion;
import Bussines.dtNoticia;
import Bussines.dtPublicacion;

/**
 * Session Bean implementation class DataJPA
 */
@Singleton
@LocalBean
public class DataJPA implements DataJPARemote, DataJPALocal {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.nicolas.tse.practico.jpa");
	EntityManager em = emf.createEntityManager();
	//@PersistenceContext(unitName = "com.nicolas.tse.practico.jpa")
    //private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DataJPA() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Noticia> cargarNoticias() {
		// TODO Auto-generated method stub
		return (ArrayList<Noticia>) em.createNamedQuery("Noticia.findAll").getResultList();

	}

	@Override
	public ArrayList<Publicacion> cargarPublicaciones() {
		// TODO Auto-generated method stub
		return (ArrayList<Publicacion>) em.createNamedQuery("Publicacion.findAll").getResultList();
	}

	@Override
	public void guardarPub(Publicacion p) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	@Override
	public void guardarNot(Noticia n) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(n);
		em.getTransaction().commit();
	}

}
