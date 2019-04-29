package Bussines;

import java.io.Serializable;

public class dtPublicacion implements Serializable {
	
	public int id;
	public String url;
	public String tipo;
	
	public dtPublicacion(int id, String url, String tipo) {
		this.id=id;
		this.url=url;
		this.tipo=tipo;
		
	}

}
