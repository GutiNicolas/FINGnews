package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import Bussines.dtNoticia;
import Bussines.dtNotpub;
import Bussines.dtPublicacion;



/**
 * Session Bean implementation class DataBean
 */
@Singleton
@LocalBean
public class DataBean implements DataBeanRemote, DataBeanLocal {

	String jdbUrl = "jdbc:postgresql://localhost:5432/noticias";
	String username = "postgres";
	String passwd = "postgres";
	String sql = "";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
    /**
     * Default constructor. 
     */
    public DataBean() {
   //     cargarDatos(); //PARA TEST
    	
    }
    
    @Override
    public void conectar() {
    	try {
    		Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(jdbUrl, username, passwd);
		//	System.out.println("CONEXION CON DB");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    @Override
    public void desconectar() {
    	try {
    	
    	if(stmt != null)			
			stmt.close();	
    	if(rs != null)
    		rs.close();
    	if(conn != null)
    		conn.close();
    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    

	@Override
	public String hayDatos() {
		if( conn != null)
			return "HAY DATOS";
		else
			return "NO HAY DATOS";
	}

	@Override
	public void cargarNoticias(ArrayList<dtNoticia> noti) {
		try {
			sql = "SELECT * FROM noticia";	
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				dtNoticia dtn= new dtNoticia(rs.getInt(1),rs.getString(2),rs.getString(3));
				noti.add(dtn);
				
			}
				
				
			} catch (SQLException e) {			
				e.printStackTrace();
			}
	}

	@Override
	public void cargarPublicaciones(ArrayList<dtPublicacion> prop) {
		
		try {
		sql = "SELECT * FROM publicacion";		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			dtPublicacion dtp= new dtPublicacion(rs.getInt(1),rs.getString(2),rs.getString(3));
			prop.add(dtp);
			
		}
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void cargarNotpub(ArrayList<dtNotpub> np) {
		try {
			sql = "SELECT * FROM notpub";		
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				dtNotpub dtnp= new dtNotpub(rs.getInt(1),rs.getInt(2));
				np.add(dtnp);
				
			}
				
				
			} catch (SQLException e) {			
				e.printStackTrace();
			}
	}

	@Override
	public void guardarPub(dtPublicacion dtp, int idn) {
		
		try {
			sql = "INSERT INTO publicacion (idp,url,tipo) VALUES ("+dtp.id+",'"+dtp.url+"','"+dtp.tipo+"')";	
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO notpub (idn,idp) VALUES ("+idn+","+dtp.id+")";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void guardarNot(dtNoticia dtn) {
		try {
			sql = "INSERT INTO noticia (id,titulo,descripcion) VALUES ("+dtn.id+",'"+dtn.titulo+"','"+dtn.descripcion+"')";	
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	


}
