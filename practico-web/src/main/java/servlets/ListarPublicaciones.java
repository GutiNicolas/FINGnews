package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bussines.ControladorLocal;
import Bussines.dtNoticia;
import Bussines.dtPublicacion;

/**
 * Servlet implementation class ListarPublicaciones
 */
@WebServlet("/ListarPublicaciones")
public class ListarPublicaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ControladorLocal cl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPublicaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("nid")!=null) {
			int id= Integer.parseInt(request.getParameter("nid"));		
			List<dtPublicacion> ldtp= cl.ListarPublicaciones(id);
			dtNoticia dtn= cl.obtenerNoticia(id);
			request.setAttribute("publicaciones", ldtp);
			request.setAttribute("noticia", dtn);
			request.getRequestDispatcher("noticia.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("ListarNoticias").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
