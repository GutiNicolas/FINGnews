package Bussines;

import javax.json.Json;
import javax.json.JsonObject;

public class dtCrearPublicacion {
	String tipo;
	String url;
	String idn;
	
	public dtCrearPublicacion() {}
	
	public dtCrearPublicacion (String tipo, String url, String idn) {
		this.tipo=tipo;
		this.url=url;
		this.idn=idn;
				
	}
	
	
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdn() {
		return idn;
	}

	public void setIdn(String idn) {
		this.idn = idn;
	}

	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("tipo", this.tipo)
				.add("url", this.url)
				.add("idn", this.idn)
				.build();
		
	}
}
