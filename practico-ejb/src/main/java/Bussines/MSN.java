package Bussines;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import Data.DataBeanLocal;

/**
 * Message-Driven Bean implementation class for: MSN
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "queue_alta_noticia"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "queue_alta_noticia")
public class MSN implements MessageListener {

	
	@EJB private ControladorLocal cont;
    /**
     * Default constructor. 
     */
    public MSN() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	TextMessage textMessage = (TextMessage) message;
    	try {
			String mens = textMessage.getText();
			String[] entero = mens.split("-");
			String titulo = entero[0];
			String descp = entero[1];
			System.out.println(mens);
			cont.AgregarNoticia(titulo, descp);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
