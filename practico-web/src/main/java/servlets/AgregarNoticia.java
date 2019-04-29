package servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bussines.ControladorLocal;

/**
 * Servlet implementation class AgregarNoticia
 */
@WebServlet("/AgregarNoticia")
public class AgregarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ControladorLocal cl; 
	
	/**
	@Resource(mappedName="jms/queue_alta_noticia")
	  private Destination destination;
	@Resource(mappedName="jms/RemoteConnectionFactory")
	  private ConnectionFactory cf;
	
	**/
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("agregarnoticia.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("titulo")!=null) {
			if(request.getParameter("descripcion")!=null) {
				String titulo = request.getParameter("titulo");
				String desc = request.getParameter("descripcion");
				
				
				String text = titulo + "-" + desc;
				/**
				try {
					QueueConnection qconn = (QueueConnection) cf.createConnection("invitado","invitado");
					qconn.start();
					QueueSession sess = qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
					MessageProducer producer= sess.createProducer(destination);			
				    TextMessage msg = sess.createTextMessage(text);
				    producer.send(msg);
				    
				    producer.close();
				    sess.close();
				    qconn.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 			      
			    **/
				
				request.getRequestDispatcher("index.jsp?msg=oknoticia").forward(request, response);
			}else
				request.getRequestDispatcher("index.jsp?msg=nok").forward(request, response);
		}else
			request.getRequestDispatcher("index.jsp?msg=nok").forward(request, response);
	}

}
