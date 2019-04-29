package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bussines.ControladorLocal;

/**
 * Servlet implementation class Arranque
 */
@WebServlet("/Arranque")
public class Arranque extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ControladorLocal cl;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Arranque() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		cl.cargarDatosJPA();
    	response.sendRedirect("faces/noticias.xhtml");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        	cl.cargarDatos();
        	response.sendRedirect("index.jsp");
        }
}
