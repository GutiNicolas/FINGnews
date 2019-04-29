package servlets;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bussines.ControladorLocal;
import Bussines.dtNoticia;

/**
 * Servlet implementation class ListarNoticias
 */
@WebServlet("/ListarNoticias")
public class ListarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ControladorLocal cl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarNoticias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<dtNoticia> dtn=cl.ListarNoticias();
		request.setAttribute("noticias", dtn);
		request.getRequestDispatcher("noticias.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
