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
 * Servlet implementation class AgregarPublicacion
 */
@WebServlet("/AgregarPublicacion")
public class AgregarPublicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ControladorLocal cl;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarPublicacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("nid")!=null) {
			int id = Integer.parseInt(request.getParameter("nid"));
			dtNoticia dtn= cl.obtenerNoticia(id);
			request.setAttribute("titulo", dtn.titulo);
			request.setAttribute("idn", dtn.id);
			request.getRequestDispatcher("agregarpublicacion.jsp").forward(request, response);
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
		if (request.getParameter("url")!=null) {
			if(request.getParameter("tipo")!=null) {
				String url = request.getParameter("url");
				String tipo = request.getParameter("tipo");
				int id = Integer.parseInt(request.getParameter("idn"));
				cl.AddPublication2New(tipo, url, id);
				request.getRequestDispatcher("index.jsp?msg=ok").forward(request, response);
			}else
				request.getRequestDispatcher("index.jsp?msg=nok").forward(request, response);
		}else
			request.getRequestDispatcher("index.jsp?msg=nok").forward(request, response);
	}

}
